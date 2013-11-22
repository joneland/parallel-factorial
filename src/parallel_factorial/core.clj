(ns parallel-factorial.core)  

(defn calculate-chunk-size [x]
  (let [chunk-size (quot x (.. Runtime getRuntime availableProcessors))]
    (cond 
      (= 0 chunk-size) 1
      :else chunk-size)))

(defn factorial [x]
  (cond
    (= x 0) 1
    (> x 0)
        (let [parts (partition-all (calculate-chunk-size x) (range 1N (bigint (inc x))))]
          (reduce * (pmap #(reduce * %) parts)))
    :else (throw (ArithmeticException. (str "Cannot calculate factorial of negative integer " x)))))

(defn convert-to-seconds [millis]
  (format "Processed in %.3f seconds"  (float (/  millis 1000))))

(defn benchmark [items]
  (let [start (System/currentTimeMillis)
        result (doall (pmap factorial items))]
    (convert-to-seconds (- (System/currentTimeMillis) start)))) 
