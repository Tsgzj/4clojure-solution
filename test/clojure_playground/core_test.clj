(ns clojure-playground.core-test
  (:require [clojure.test :refer :all]
            [clojure-playground.core :refer :all]
            [clojure-playground.4clojure :refer :all]))

(deftest a-test
  (testing "Fixed"
    (is (= 1 1))))

(deftest factorial-test
  (testing "Factorial with factorial-reduce"
    (is (= (factorial 20) )2432902008176640000)))

(deftest bfs-test
  (testing "Simple test for BFS"
    (is (= (bfs [1 [2 [4]] [3 [5]]]) '(1 2 3 4 5)))))

(deftest dfs-test
  (testing "Simple test for DFS"
    (is (= (dfs [1]) '(1)))
    (is (= (dfs [1 [2 [3] [4]] [6 [5]]]) '(1 2 3 4 6 5)))))

(deftest clojure-n27-test
  (testing "4clojure n27"
    (is (= true (n27 "racecar")))
    (is (= true (n27 [:foo :bar :foo])))
    (is (= true (n27 '(1 1 3 3 1 1))))
    (is (= false (n27 '(1 2 3 4 5))))
    (is (= false (n27 ''(:a :b :c))))))
