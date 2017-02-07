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

(deftest clojure-n21-test
  (testing "4clojure n21"
    (is (= (n21 '(4 5 6 7) 2) 6))
    (is (= (n21 [:a :b :c] 0) :a))
    (is (= (n21 [1 2 3 4] 1) 2))
    (is (= (n21 '([1 2] [3 4] [5 6]) 2) [5 6]))))

(deftest clojure-n27-test
  (testing "4clojure n27"
    (is (= true (n27 "racecar")))
    (is (= true (n27 [:foo :bar :foo])))
    (is (= true (n27 '(1 1 3 3 1 1))))
    (is (= false (n27 '(1 2 3 4 5))))
    (is (= false (n27 ''(:a :b :c))))))

(deftest clojure-n22-test
  (testing "4clojure n27"
    (is (= 5  (n22 '(1 2 3 3 1))))
    (is (= 11 (n22 "Hello World")))
    (is (= 3  (n22 [[1 2] [3 4] [5 6]])))
    (is (= 1  (n22 '(13))))
    (is (= 3  (n22 '(:a :b :c))))))

(deftest clojure-n23-test
  (testing "4clojure n23"
    (is (= (n23 [1 2 3 4 5]) [5 4 3 2 1]))
    (is (= (n23 (sorted-set 5 7 2 7)) '(7 5 2)))
    (is (= (n23 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))))

(deftest clojure-n24-test
  (testing "4clojure n24"
    (is (= (n24 [1 2 3]) 6))
    (is (= (n24 (list 0 -2 5 5)) 8))
    (is (= (n24 #{4 2 1}) 7))
    (is (= (n24 '(0 0 -1)) -1))
    (is (= (n24 '(1 10 3)) 14))))

(deftest clojure-n25-test
  (testing "4clojure n25"
    (is (= (n25 #{1 2 3 4 5}) '(1 3 5)))
    (is (= (n25 [4 2 1 6]) '(1)))
    (is (= (n25 [2 2 4 6]) '()))
    (is (= (n25 [1 1 1 3]) '(1 1 1 3)))))

(deftest clojure-n26-test
  (testing "4clojure n26"
    (is (= (n26 3) '(1 1 2)))
    (is (= (n26 6) '(1 1 2 3 5 8)))
    (is (= (n26 8) '(1 1 2 3 5 8 13 21)))))
