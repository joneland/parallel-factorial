(ns parallel-factorial.core)

(defn factorial [x]
  (cond
    (= x 0) 1
    (> x 0) (reduce *' (range 1 (inc x)))
    :else (throw (ArithmeticException. (str "Cannot calculate factorial of negative integer " x)))))

(defn sequential [x n]
  (time (doall (map factorial (repeat n x)))))

(defn parallel [x n]
  (time (doall (pmap factorial (repeat n x)))))
