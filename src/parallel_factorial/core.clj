(ns parallel-factorial.core)

(defn factorial [x]
  (cond
    (= x 0) 1
    (> x 0) (reduce * (range 1 (inc x)))
    :else (throw (ArithmeticException. (str "Cannot calculate factorial of negative integer " x)))))
