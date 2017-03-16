(ns fclj.core-test
  (:require [clojure.test :refer :all]
            [clojure.string]
            [fclj.core :refer :all]
            [fclj.4clojure :refer :all]
            [fclj.4clojure-03x :refer :all]
            [fclj.4clojure-04x :refer :all]
            [fclj.4clojure-05x :refer :all]
            [fclj.4clojure-08x :refer :all]
            [fclj.4clojure-06x :refer :all]
            [fclj.4clojure-10x :refer :all]
            [fclj.4clojure-16x :refer :all]))

(defmacro test-list
  [f lst]
  `(deftest f#
     (testing
         (format "Testing %s" (str (quote ~f)))
       (for [tc# (clojure.edn/read-string
                  (clojure.string/replace
                   ~lst
                   "__"
                   (str (quote ~f))))]
         '(is tc#)))))

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

(deftest clojure-n40-test
  (testing "4clj n40"
    (is (= (n40 0 [1 2 3]) [1 0 2 0 3]))
    (is (= (apply str (n40 ", " ["one" "two" "three"])) "one, two, three"))
    (is (= (n40 :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))))

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

(deftest clojure-n43-test
  (testing "4clj n43"
    (is (= (n43 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
    (is (= (n43 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
    (is (= (n43 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))))

(deftest clojure-n44-test
  (testing "4clj n44"
    (is (= (n44 2 [1 2 3 4 5]) '(3 4 5 1 2)))
    (is (= (n44 -2 [1 2 3 4 5]) '(4 5 1 2 3)))
    (is (= (n44 6 [1 2 3 4 5]) '(2 3 4 5 1)))
    (is (= (n44 1 '(:a :b :c)) '(:b :c :a)))
    (is (= (n44 -4 '(:a :b :c)) '(:c :a :b)))))

(deftest clojure-n46-test
  (testing "4clj n46"
    (is (= 3 ((n46 nth) 2 [1 2 3 4 5])))
    (is (= true ((n46 >) 7 8)))
    (is (= 4 ((n46 quot) 2 8)))
    (is (= [1 2 3] ((n46 take) [1 2 3 4 5] 3)))))

(deftest clojure-n46e-test
  (testing "4clj n46-enhanced"
    (is (= 3 ((n46-enhanced nth) 2 [1 2 3 4 5])))
    (is (= true ((n46-enhanced >) 7 8)))
    (is (= 4 ((n46-enhanced quot) 2 8)))
    (is (= [1 2 3] ((n46-enhanced take) [1 2 3 4 5] 3)))))

(deftest clojure-n49-test
  (testing "4clj n49"
    (is (= (n49 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
    (is (= (n49 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
    (is (= (n49 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]))))

(deftest clojure-n50-test
  (testing "4clj n50"
    (is (= (set (n50 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
    (is (= (set (n50 [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
    (is (= (set (n50 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))))

(deftest clojure-n53-test
  (testing "4clj n53"
    (is (= (n53 [1 0 1 2 3 0 4 5]) [0 1 2 3]))
    (is (= (n53 [5 6 1 3 2 7]) [5 6]))
    (is (= (n53 [2 3 3 4 5]) [3 4 5]))
    (is (= (n53 [7 6 5 4]) []))))

(deftest clojure-n54-test
  (testing "4clj n54"
    (is (= (n54 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
    (is (= (n54 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
    (is (= (n54 3 (range 8)) '((0 1 2) (3 4 5))))))

(deftest clojure-n55-test
  (testing "4clj n55"
    (is (= (n55 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
    (is (= (n55 [:b :a :b :a :b]) {:a 2, :b 3}))
    (is (= (n55 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))))

(deftest clojure-n56-test
  (testing "4clj n56"
    (is (= (n56 [1 2 1 3 1 2 4]) [1 2 3 4]))
    (is (= (n56 [:a :a :b :b :c :c]) [:a :b :c]))
    (is (= (n56 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
    (is (= (n56 (range 50)) (range 50)))))

(deftest clojure-n61-test
  (testing "4clj n61"
    (is (= (n61 [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
    (is (= (n61 [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
    (is (= (n61 [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}))))

(deftest clojure-n62-test
  (testing "4clj n62"
    (is (= (take 5 (n62 #(* 2 %) 1)) [1 2 4 8 16]))
    (is (= (take 100 (n62 inc 0)) (take 100 (range))))
    (is (= (take 9 (n62 #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))))))

(deftest clojure-n66-test
  (testing "4clj n66"
    (is (= (n66 2 4) 2))
    (is (= (n66 10 5) 5))
    (is (= (n66 5 7) 1))
    (is (= (n66 1023 858) 33))))

(deftest clojure-n81-test
  (testing "4clj n81"
    (is (= (n81 #{0 1 2 3} #{2 3 4 5}) #{2 3}))
    (is (= (n81 #{0 1 2} #{3 4 5}) #{}))
    (is (= (n81 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))))

(deftest clojure-n81-test-set-theory
  (testing "4clj n81"
    (is (= (n81-set-theory #{0 1 2 3} #{2 3 4 5}) #{2 3}))
    (is (= (n81-set-theory #{0 1 2} #{3 4 5}) #{}))
    (is (= (n81-set-theory #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))))

(deftest clojure-n83-test
  (testing "4clj n83"
    (is (= false (n83 false false)))
    (is (= true (n83 true false)))
    (is (= false (n83 true)))
    (is (= true (n83 false true false)))
    (is (= false (n83 true true true)))
    (is (= true (n83 true true true false)))))

(deftest clojure-107-test
  (testing "4clj n107"
    (is (= 256 ((n107 2) 16),((n107 8) 2)))
    (is (= [1 8 27 64] (map (n107 3) [1 2 3 4])))
    (is (= [1 2 4 8 16] (map #((n107 %) 2) [0 1 2 3 4])))))

(deftest clojure-n166-test
  (testing "4clj n166"
    (is (= :gt (n166 < 5 1)))
    (is (= :eq (n166 (fn [x y] (< (count x) (count y))) "pear" "plum")))
    (is (= :lt (n166 (fn [x y] (< (mod x 5) (mod y 5))) 21 3)))
    (is (= :gt (n166 > 0 2)))))
