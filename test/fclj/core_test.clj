(ns fclj.core-test
  (:require [clojure.test :refer :all]
            [fclj.core :refer :all]
            [fclj.4clojure :refer :all]
            [fclj.4clojure_03x :refer :all]
            [fclj.4clojure_04x :refer :all]))

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

(deftest clojure-n28-test
  (testing "4clojure n28"
    (is (= (n28 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
    (is (= (n28 ["a" ["b"] "c"]) '("a" "b" "c")))
    (is (= (n28 '((((:a))))) '(:a)))))

(deftest clojure-n29-test
  (testing "4clojure n29"
    (is (= (n29 "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (n29 "nothing")))
    (is (= (n29 "$#A(*&987Zf") "AZ"))))

(deftest clojure-n30-test
  (testing "4clj n30"
    (is (= (apply str (n30 "Leeeeeerrroyyy")) "Leroy"))
    (is (= (n30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (n30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))))

(deftest clojure-n32-test
  (testing "4clj n32"
    (is (= (n32 [1 2 3]) '(1 1 2 2 3 3)))
    (is (= (n32 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
    (is (= (n32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (n32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))))

(deftest clojure-n33-test
  (testing "4clj n33"
    (is (= (n33 [1 2 3] 2) '(1 1 2 2 3 3)))
    (is (= (n33 [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
    (is (= (n33 [4 5 6] 1) '(4 5 6)))
    (is (= (n33 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (n33 [44 33] 2) [44 44 33 33]))))

(deftest clojure-n34-test
  (testing "4clj n34"
    (is (= (n34 1 4) '(1 2 3)))
    (is (= (n34 -2 2) '(-2 -1 0 1)))
    (is (= (n34 5 8) '(5 6 7)))))

(deftest clojure-n38-test
  (testing "4clj n38"
    (is (= (n38 1 8 3 4) 8))
    (is (= (n38 30 20) 30))
    (is (= (n38 45 67 11) 67))))

(deftest clojure-n39-test
  (testing "4clj n39"
    (is (= (n39 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
    (is (= (n39 [1 2] [3 4 5 6]) '(1 3 2 4)))
    (is (= (n39 [1 2 3 4] [5]) [1 5]))
    (is (= (n39 [30 20] [25 15]) [30 25 20 15]))))

(deftest clojure-n41-test
  (testing "4clj n41"
    (is (= (n41 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
    (is (= (n41 [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (n41 [1 2 3 4 5 6] 4) [1 2 3 5 6]))))

(deftest clojure-n42-test
  (testing "4clj n42"
    (is (= (n42 1) 1))
    (is (= (n42 3) 6))
    (is (= (n42 5) 120))
    (is (= (n42 8) 40320))))

(deftest clojure-n42-lowgolf-test
  (testing "4clj n42"
    (is (= (n42-low-golf 1) 1))
    (is (= (n42-low-golf 3) 6))
    (is (= (n42-low-golf 5) 120))
    (is (= (n42-low-golf 8) 40320))))

(deftest clojure-n49-test
  (testing "4clj n49"
    (is (= (n49 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
    (is (= (n49 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
    (is (= (n49 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]))))
