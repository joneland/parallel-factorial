(ns parallel-factorial.core)  

(defn factorial [x]
  (cond
    (= x 0) 1
    (> x 0) (reduce *' (range 1N (bigint (inc x))))
    :else (throw (ArithmeticException. (str "Cannot calculate factorial of negative integer " x)))))

(defn parallel [x n]
  (doall (pmap factorial (repeat n x))))

(defn convert-to-seconds[millis]
  (format "Processed in %.3f seconds"  (float (/  millis 1000))))

(defn benchmark[x n]
  (let [start (System/currentTimeMillis)
        work (parallel x n)]
  (convert-to-seconds (- (System/currentTimeMillis) start)))) 
