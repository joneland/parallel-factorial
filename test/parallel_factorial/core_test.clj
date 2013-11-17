(ns parallel-factorial.core-test
  (:require [clojure.test :refer :all]
            [parallel-factorial.core :refer :all]))

(deftest calculate-factorial 
  (testing "with zero"
    (is (= (factorial 0) 1)))
  (testing "with positive integers greater than zero"
    (is (= (factorial 1) 1))
    (is (= (factorial 3) 6))
    (is (= (factorial 5) 120)))
  (testing "with negative integers"
    (is (thrown-with-msg? ArithmeticException #"Cannot calculate factorial of negative integer -1" (factorial -1))))) 
