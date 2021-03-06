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
            [fclj.4clojure-07x :refer :all]
            [fclj.4clojure-09x :refer :all]
            [fclj.4clojure-10x :refer :all]
            [fclj.4clojure-11x :refer :all]
            [fclj.4clojure-12x :refer :all]
            [fclj.4clojure-13x :refer :all]
            [fclj.4clojure-14x :refer :all]
            [fclj.4clojure-15x :refer :all]
            [fclj.4clojure-16x :refer :all]
            [fclj.4clojure-17x :refer :all]
            [fclj.4clojure-19x :refer :all]))

(defmacro test-list
  [f lst]
  `(deftest f#
     (testing
      (format "Testing %s" (str (quote ~f)))
       (for [tc# (clojure.edn/read-string
                  (clojure.string/replace
                   ~lst
                   "n112"
                   (str (quote ~f))))]
         '(is tc#)))))

(deftest factorial-test
  (testing "Factorial with factorial-reduce"
    (is (= (factorial 20)) 2432902008176640000)))

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
    (is (= (n23 [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]]))))

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

(deftest clojure-n58
  (testing "comp"
    (is (= [3 2 1] ((n58 rest reverse) [1 2 3 4])))
    (is (= 5 ((n58 (partial + 3) second) [1 2 3 4])))
    (is (= true ((n58 zero? #(mod % 8) +) 3 5 7 9)))
    (is (= "HELLO" ((n58 #(.toUpperCase %) #(apply str %) take) 5 "hello world")))))

(deftest clojure-n59
  (testing "n59"
    (is (= [21 6 1] ((n59 + max min) 2 3 5 1 6 4)))
    (is (= ["HELLO" 5] ((n59 #(.toUpperCase %) count) "hello")))
    (is (= [2 6 4] ((n59 :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})))))

(deftest clojure-n60-test
  (testing "n60"
    (is (= (take 5 (n60 + (range))) [0 1 3 6 10]))
    (is (= (n60 conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))
    (is (= (last (n60 * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120))))

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

(deftest coljure-n63-test
  (testing "n63"
    (is (= (n63 #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
    (is (= (n63 #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
           {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
    (is (= (n63 count [[1] [1 2] [3] [1 2 3] [2 3]])
           {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}))))

(deftest clojure-n65-test
  (testing "n65"
    (is (= :map (n65 {:a 1, :b 2})))
    (is (= :list (n65 (range (rand-int 20)))))
    (is (= :vector (n65 [1 2 3 4 5 6])))
    (is (= :set (n65 #{10 (rand-int 5)})))
    (is (= [:map :set :vector :list] (map n65 [{} #{} [] ()])))))

(deftest clojure-n66-test
  (testing "4clj n66"
    (is (= (n66 2 4) 2))
    (is (= (n66 10 5) 5))
    (is (= (n66 5 7) 1))
    (is (= (n66 1023 858) 33))))

(deftest clojure-n67-test
  (testing "4clj n67"
    (is (= (n67 2) [2 3]))
    (is (= (n67 5) [2 3 5 7 11]))
    (is (= (last (n67 100)) 541))))

(deftest clojure-n69
  (testing "4clj n69"
    (is (= (n69 * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
           {:a 4, :b 6, :c 20}))
    (is (= (n69 - {1 10, 2 20} {1 3, 2 10, 3 15})
           {1 7, 2 10, 3 15}))
    (is (= (n69 concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
           {:a [3 4 5], :b [6 7], :c [8 9]}))))

(deftest clojure-n70-test
  (testing "4clj n70"
    (is (= (n70  "Have a nice day.")
           ["a" "day" "Have" "nice"]))
    (is (= (n70  "Clojure is a fun language!")
           ["a" "Clojure" "fun" "is" "language"]))
    (is (= (n70  "Fools fall for foolish follies.")
           ["fall" "follies" "foolish" "Fools" "for"]))))

(deftest clojure-n74-test
  (testing "4clj n74"
    (is (= (n74 "4,5,6,7,8,9") "4,9"))
    (is (= (n74 "15,16,25,36,37") "16,25,36"))))

(deftest clojure-n75
  (testing "4clj n75"
    (is (= (n75 1) 1))
    (is (= (n75 10) (count '(1 3 7 9)) 4))
    (is (= (n75 40) 16))
    (is (= (n75 99) 60))))

(deftest clojure-n77-test
  (testing "4clj n77"
    (is (= (n77 ["meat" "mat" "team" "mate" "eat"])
           #{#{"meat" "team" "mate"}}))
    (is (= (n77 ["veer" "lake" "item" "kale" "mite" "ever"])
           #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))))

(deftest clojure-n78
  (testing "4clj n78"
    (is (= (letfn [(triple [x] #(sub-two (* 3 x)))
               (sub-two [x] #(stop?(- x 2)))
               (stop? [x] (if (> x 50) x #(triple x)))]
         (n78 triple 2))
       82))
    (is (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
               (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
         (map (partial n78 my-even?) (range 6)))
           [true false true false true false]))))

(deftest clojure-n79
  (testing "4clj n79"
    (is (= 7 (n79 '([1]
               [2 4]
               [5 1 4]
               [2 3 4 5])))) ; 1->2->1->3
    (is (= 20 (n79 '([3]
                [2 4]
                [1 9 3]
                [9 9 2 4]
                [4 6 6 7 8]
                     [5 7 3 5 1 4])))))) ; 3->4->3->2->7->1))

(deftest clojure-n79-alt
  (testing "4clj n79"
    (is (= 7 (n79-alt '([1]
                    [2 4]
                    [5 1 4]
                    [2 3 4 5])))) ; 1->2->1->3
    (is (= 20 (n79-alt '([3]
                     [2 4]
                     [1 9 3]
                     [9 9 2 4]
                     [4 6 6 7 8]
                     [5 7 3 5 1 4]))))))

(deftest clojure-n80-test
  (testing "4clj n80"
    (is (= (n80 6) true))
    (is (= (n80 7) false))
    (is (= (n80 496) true))
    (is (= (n80 500) false))
    (is (= (n80 8128) true))))

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

(deftest clojure-n85-test
  (testing "n85"
    (is (= (n85 #{1 :a}) #{#{1 :a} #{:a} #{} #{1}}))
    (is (= (n85 #{}) #{#{}}))
    (is (= (n85 #{1 2 3}) #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}))
    (is (= (count (n85 (into #{} (range 10)))) 1024))))

(deftest clojure-n86-test
  (testing "n86"
    (is (= (n86 7) true))
    (is (= (n86 986543210) true))
    (is (= (n86 2) false))
    (is (= (n86 3) false))))

(deftest clojure-n88-test
  (testing "4clj n88"
    (is (= (n88 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
    (is (= (n88 #{:a :b :c} #{}) #{:a :b :c}))
    (is (= (n88 #{} #{4 5 6}) #{4 5 6}))
    (is (= (n88 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))))

(deftest clojure-n90-test
  (testing "4clojure n90"
    (is (= (n90 #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
           #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
             ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
             ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))
    (is (= (n90 #{1 2 3} #{4 5})
           #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
    (is (= 300 (count (n90 (into #{} (range 10))
                           (into #{} (range 30))))))))

(deftest clojure-n92-test
  (testing "n92"
    (is (= 14 (n92 "XIV")))
    (is (= 827 (n92 "DCCCXXVII")))
    (is (= 3999 (n92 "MMMCMXCIX")))
    (is (= 48 (n92 "XLVIII")))))

(deftest clojure-n93-test
  (testing "4clojure n93"
    (is (= (n93 [["Do"] ["Nothing"]])
           [["Do"] ["Nothing"]]))
    (is (= (n93 [[[[:a :b]]] [[:c :d]] [:e :f]])
           [[:a :b] [:c :d] [:e :f]]))
    (is (= (n93 '((1 2) ((3 4) ((((5 6)))))))
           '((1 2) (3 4) (5 6))))))

(deftest coljure-n95-test
  (testing "n95"
    (is (= (n95 '(:a (:b nil nil) nil)) true))
    (is (= (n95 '(:a (:b nil nil))) false))
    (is (= (n95 [1 nil [2 [3 nil nil] [4 nil nil]]]) true))
    (is (= (n95 [1 [2 nil nil] [3 nil nil] [4 nil nil]]) false))
    (is (= (n95 [1 [2 [3 [4 nil nil] nil] nil] nil]) true))
    (is (= (n95 [1 [2 [3 [4 false nil] nil] nil] nil]) false))
    (is (= (n95 '(:a nil ())) false))))

(deftest clojure-n96-test
  (testing "n96"
    (is (= (n96 '(:a (:b nil nil) (:b nil nil))) true))
    (is (= (n96 '(:a (:b nil nil) nil)) false))
    (is (= (n96 '(:a (:b nil nil) (:c nil nil))) false))
    (is (= (n96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
           true))
    (is (= (n96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
           false))
    (is (= (n96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [6 nil nil] nil]] nil]])
           false))))

(deftest coljure-n97-test
  (testing "n97"
    (is (= (n97 1) [1]))
    (is (= (map n97 (range 1 6))
           [[1]
            [1 1]
            [1 2 1]
            [1 3 3 1]
            [1 4 6 4 1]]))
    (is (= (n97 11)
           [1 10 45 120 210 252 210 120 45 10 1]))))

(deftest coljure-n97-v2-test
  (testing "n97"
    (is (= (n97-v2 1) [1]))
    (is (= (map n97-v2 (range 1 6))
           [[1]
            [1 1]
            [1 2 1]
            [1 3 3 1]
            [1 4 6 4 1]]))
    (is (= (n97-v2 11)
           [1 10 45 120 210 252 210 120 45 10 1]))))

(deftest clojure-n98-test
  (testing "n98"
    (is (= (n98 #(* % %) #{-2 -1 0 1 2})
       #{#{0} #{1 -1} #{2 -2}}))
    (is (= (n98 #(rem % 3) #{0 1 2 3 4 5 })
       #{#{0 3} #{1 4} #{2 5}}))
    (is (= (n98 identity #{0 1 2 3 4})
       #{#{0} #{1} #{2} #{3} #{4}}))
    (is (= (n98 (constantly true) #{0 1 2 3 4})
       #{#{0 1 2 3 4}}))))

(deftest clojure-n98-v2-test
  (testing "n98-v2"
    (is (= (n98-v2 #(* % %) #{-2 -1 0 1 2})
           #{#{0} #{1 -1} #{2 -2}}))
    (is (= (n98-v2 #(rem % 3) #{0 1 2 3 4 5 })
           #{#{0 3} #{1 4} #{2 5}}))
    (is (= (n98-v2 identity #{0 1 2 3 4})
           #{#{0} #{1} #{2} #{3} #{4}}))
    (is (= (n98-v2 (constantly true) #{0 1 2 3 4})
           #{#{0 1 2 3 4}}))))

(deftest clojure-n99-test
  (testing "n99"
    (is (= (n99 1 1) [1]))
    (is (= (n99 99 9) [8 9 1]))
    (is (= (n99 999 99) [9 8 9 0 1]))))

(deftest clojure-n99-lg-test
  (testing "n99"
    (is (= (n99-low-golf 1 1) [1]))
    (is (= (n99-low-golf 99 9) [8 9 1]))
    (is (= (n99-low-golf 999 99) [9 8 9 0 1]))))

(deftest clojure-n100-test
  (testing "n100"
    (is (== (n100 2 3) 6))
    (is (== (n100 5 3 7) 105))
    (is (== (n100 1/3 2/5) 2))
    (is (== (n100 3/4 1/6) 3/2))
    (is (== (n100 7 5/7 2 3/5) 210))))

(deftest clojure-n101-test
  (testing "n101"
    (is (= (n101 "kitten" "sitting") 3))
    (is (= (n101 "closure" "clojure") (n101 "clojure" "closure") 1))
    (is (= (n101 "xyx" "xyyyx") 2))
    (is (= (n101 "" "123456") 6))
    (is (= (n101 "Clojure" "Clojure") (n101 "" "") (n101 [] []) 0))
    (is (= (n101 [1 2 3 4] [0 2 3 4 5]) 2))
    (is (= (n101 '(:a :b :c :d) '(:a :d)) 2))
    (is (= (n101 "ttttattttctg" "tcaaccctaccat") 10))
    (is (= (n101 "gaattctaatctc" "caaacaaaaaattt") 9))))

(deftest clojure-n102-test
  (testing "n102"
    (is (= (n102 "something") "something"))
    (is (= (n102 "multi-word-key") "multiWordKey"))
    (is (= (n102 "leaveMeAlone") "leaveMeAlone"))))

(deftest clojure-n103-test
  (testing "n103"
    (is (= (n103 1 #{4 5 6}) #{#{4} #{5} #{6}}))
    (is (= (n103 10 #{4 5 6}) #{}))
    (is (= (n103 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}}))
    (is (= (n103 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                             #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}}))
    (is (= (n103 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                                #{:a "abc"} #{:a "efg"} #{"abc" "efg"}}))))

(deftest clojure-n104-test
  (testing "n104"
    (is (= "I" (n104 1)))
    (is (= "XXX" (n104 30)))
    (is (= "IV" (n104 4)))
    (is (= "CXL" (n104 140)))
    (is (= "DCCCXXVII" (n104 827)))
    (is (= "MMMCMXCIX" (n104 3999)))
    (is (= "XLVIII" (n104 48)))))

(deftest clojure-n105-test
  (testing "n105"
    (is (= {} (n105 [])))
    (is (= {:a [1]} (n105 [:a 1])))
    (is (= {:a [1], :b [2]} (n105 [:a 1, :b 2])))
    (is (= {:a [1 2 3], :b [], :c [4]} (n105 [:a 1 2 3 :b :c 4])))))

(deftest clojure-n105-better-test
  (testing "n105"
    (is (= {} (n105-better [])))
    (is (= {:a [1]} (n105-better [:a 1])))
    (is (= {:a [1], :b [2]} (n105-better [:a 1, :b 2])))
    (is (= {:a [1 2 3], :b [], :c [4]} (n105-better [:a 1 2 3 :b :c 4])))))

(deftest clojure-n106-test
  (testing "n106"
    (is (= 1 (n106 1 1)))  ; 1
    (is (= 3 (n106 3 12))) ; 3 6 12
    (is (= 3 (n106 12 3))) ; 12 6 3
    (is (= 3 (n106 5 9)))  ; 5 7 9
    (is (= 9 (n106 9 2)))  ; 9 18 20 10 12 6 8 4 2
    (is (= 5 (n106 9 12))))) ; 9 11 22 24 12))

(deftest clojure-107-test
  (testing "4clj n107"
    (is (= 256 ((n107 2) 16),((n107 8) 2)))
    (is (= [1 8 27 64] (map (n107 3) [1 2 3 4])))
    (is (= [1 2 4 8 16] (map #((n107 %) 2) [0 1 2 3 4])))))

(deftest clojure-108-test
  (testing "4clj n108"
    (is (= 3 (n108 [3 4 5])))
    (is (= 4 (n108 [1 2 3 4 5 6 7] [0.5 3/2 4 19])))
    (is (= 7 (n108 (range) (range 0 100 7/6) [2 3 5 7 11 13])))
    (is (= 64 (n108 (map #(* % % %) (range)) ;; perfect cubes
                    (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
                    (iterate inc 20)))))) ;; at least as large as 20))

(deftest clojure-n110-test
  (testing "4clj n110"
    (is (= [[1 1] [2 1] [1 2 1 1]] (take 3 (n110 [1]))))
    (is (= [3 1 2 4] (first (n110 [1 1 1 4 4]))))
    (is (= [1 1 1 3 2 1 3 2 1 1] (nth (n110 [1]) 6)))
    (is (= 338 (count (nth (n110 [3 2]) 15))))))

(deftest clojure-n112-test
  (testing "4clj n112"
    (is (=  (n112 10 [1 2 [3 [4 5] 6] 7])
            '(1 2 (3 (4)))))
    (is (=  (n112 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
            '(1 2 (3 (4 (5 (6 (7))))))))
    (is (=  (n112 9 (range))
            '(0 1 2 3)))
    (is (=  (n112 1 [[[[[1]]]]])
            '(((((1)))))))
    (is (=  (n112 0 [1 2 [3 [4 5] 6] 7])
            '()))
    (is (=  (n112 0 [0 0 [0 [0]]])
            '(0 0 (0 (0)))))
    (is (=  (n112 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
            '(-10 (1 (2 3 (4))))))))

(deftest clojure-n114
  (testing "n114"
    (is (= [2 3 5 7 11 13]
           (n114 4 #(= 2 (mod % 3))
                 [2 3 5 7 11 13 17 19 23])))
    (is (= ["this" "is" "a" "sentence"]
           (n114 3 #(some #{\i} %)
                 ["this" "is" "a" "sentence" "i" "wrote"])))
    (is (= ["this" "is"]
           (n114 1 #{"a"}
                 ["this" "is" "a" "sentence" "i" "wrote"])))))

(deftest coljure-115-test
  (testing "4clj n115"
    (is (= true (n115 11)))
    (is (= true (n115 121)))
    (is (= false (n115 123)))
    (is (= true (n115 0)))
    (is (= false (n115 88099)))
    (is (= true (n115 89098)))
    (is (= true (n115 89089)))
    (is (= (take 20 (filter n115 (range)))
           [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101]))))

(deftest clojuren-116-test
  (testing "n116"
    (is (= false (n116 4)))
    (is (= true (n116 563)))
    (is (= 1103 (nth (filter n116 (range)) 15)))))

(deftest clojure-118-test
  (testing "4clj n118"
    (is (= [3 4 5 6 7]
           (n118 inc [2 3 4 5 6])))
    (is (= (repeat 10 nil)
           (n118 (fn [_] nil) (range 10))))
    (is (= [1000000 1000001]
           (->> (n118 inc (range))
                (drop (dec 1000000))
                (take 2))))))

(deftest clojure-120-test
  (testing "4clj n120"
    (is (= 8 (n120 (range 10))))
    (is (= 19 (n120 (range 30))))
    (is (= 50 (n120 (range 100))))
    (is (= 50 (n120 (range 1000))))))

(deftest clojure-122-test
  (testing "n122"
    (is (= 0     (n122 "0")))
    (is (= 7     (n122 "111")))
    (is (= 8     (n122 "1000")))
    (is (= 9     (n122 "1001")))
    (is (= 255   (n122 "11111111")))
    (is (= 1365  (n122 "10101010101")))
    (is (= 65535 (n122 "1111111111111111")))))

(deftest clojure-128-test
  (testing "n128"
    (is (= {:suit :diamond :rank 10} (n128 "DQ")))
    (is (= {:suit :heart :rank 3} (n128 "H5")))
    (is (= {:suit :club :rank 12} (n128 "CA")))
    (is (= (range 13) (map (comp :rank n128 str)
                           '[S2 S3 S4 S5 S6 S7
                             S8 S9 ST SJ SQ SK SA])))))

(deftest clojure-131-test
  (testing "n131"
    (is (= true  (n131 #{-1 1 99}
                       #{-2 2 888}
                       #{-3 3 7777}))) ; ex. all sets have a subset which sums to zero
    (is (= false (n131 #{1}
                       #{2}
                       #{3}
                       #{4})))
    (is (= true  (n131 #{1})))
    (is (= false (n131 #{1 -3 51 9}
                       #{0}
                       #{9 2 81 33})))
    (is (= true  (n131 #{1 3 5}
                       #{9 11 4}
                       #{-3 12 3}
                       #{-3 4 -2 10})))
    (is (= false (n131 #{-1 -2 -3 -4 -5 -6}
                       #{1 2 3 4 5 6 7 8 9})))
    (is (= true  (n131 #{1 3 5 7}
                       #{2 4 6 8})))
    (is (= true  (n131 #{-1 3 -5 7 -9 11 -13 15}
                       #{1 -3 5 -7 9 -11 13 -15}
                       #{1 -1 2 -2 4 -4 8 -8})))
    (is (= true  (n131 #{-10 9 -8 7 -6 5 -4 3 -2 1}
                       #{10 -9 8 -7 6 -5 4 -3 2 -1})))))

(deftest clojure-132-test
  (testing "n132"
    (is (= '(1 :less 6 :less 7 4 3) (n132 < :less [1 6 7 4 3])))
    (is (= '(2) (n132 > :more [2])))
    (is (= [0 1 :x 2 :x 3 :x 4]  (n132 #(and (pos? %) (< % %2)) :x (range 5))))
    (is (empty? (n132 > :more ())))
    (is (= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
     (take 12 (->> [0 1]
                     (iterate (fn [[a b]] [b (+ a b)]))
                     (map first) ; fibonacci numbers
                     (n132 (fn [a b] ; both even or both odd
                           (= (mod a 2) (mod b 2)))
                         :same)))))))

(deftest n135-test
  (testing "n135"
    (is (= 7  (n135 2 + 5)))
    (is (= 42 (n135 38 + 48 - 2 / 2)))
    (is (= 8  (n135 10 / 2 - 1 * 2)))
    (is (= 72 (n135 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)))))

(deftest n137-test
  (testing "n137"
    (is (= [1 2 3 4 5 0 1] (n137 1234501 10)))
    (is (= [0] (n137 0 11)))
    (is (= [1 0 0 1] (n137 9 2)))
    (is (= [1 0] (let [n (rand-int 100000)] (n137 n n))))
    (is (= [16 18 5 24 15 1] (n137 Integer/MAX_VALUE 42)))))

(deftest n137-recur-test
  (testing "n137-recur"
    (is (= [1 2 3 4 5 0 1] (n137-recur 1234501 10)))
    (is (= [0] (n137-recur 0 11)))
    (is (= [1 0 0 1] (n137-recur 9 2)))
    (is (= [1 0] (let [n (rand-int 100000)] (n137-recur n n))))
    (is (= [16 18 5 24 15 1] (n137-recur Integer/MAX_VALUE 42)))))

(deftest n141-test
  (testing "n141"
    (let [notrump (n141 nil)]
      (and (is (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 9}
                                                   {:suit :club :rank 9}])))
           (is (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                                   {:suit :club :rank 10}])))))
    (is (= {:suit :club :rank 10} ((n141 :club) [{:suit :spade :rank 2}
                                                 {:suit :club :rank 10}])))
    (is (= {:suit :heart :rank 8}
           ((n141 :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                           {:suit :diamond :rank 10} {:suit :heart :rank 4}])))))

(deftest clojure-143-test
  (testing "4clj n143"
    (is (= 0 (n143 [0 1 0] [1 0 0])))
    (is (= 3 (n143 [1 1 1] [1 1 1])))
    (is (= 32 (n143 [1 2 3] [4 5 6])))
    (is (= 256 (n143 [2 5 6] [100 10 1])))))

(deftest clojure-144-ele-test
  (testing "4clj n144-ele"
    (is (= (take 3 (n144-ele 3.14 int double)) [3.14 3 3.0]))
    (is (= (take 5 (n144-ele 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7]))
    (is (= (take 12 (n144-ele 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3]))))

(deftest clojure-144-test
  (testing "4clj n144"
    (is (= (take 3 (n144 3.14 int double)) [3.14 3 3.0]))
    (is (= (take 5 (n144 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7]))
    (is (= (take 12 (n144 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3]))))

(deftest clojure-146-test
  (testing "n146"
    (is (= (n146 '{a {p 1, q 2}
                   b {m 3, n 4}})
           '{[a p] 1, [a q] 2
             [b m] 3, [b n] 4}))
    (is (= (n146 '{[1] {a b c d}
                   [2] {q r s t u v w x}})
           '{[[1] a] b, [[1] c] d,
             [[2] q] r, [[2] s] t,
             [[2] u] v, [[2] w] x}))
    (is (= (n146 '{m {1 [a b c] 3 nil}})
           '{[m 1] [a b c], [m 3] nil}))))

(deftest clojure-146s-test
  (testing "n146"
    (is (= (n146s '{a {p 1, q 2}
                   b {m 3, n 4}})
           '{[a p] 1, [a q] 2
             [b m] 3, [b n] 4}))
    (is (= (n146s '{[1] {a b c d}
                   [2] {q r s t u v w x}})
           '{[[1] a] b, [[1] c] d,
             [[2] q] r, [[2] s] t,
             [[2] u] v, [[2] w] x}))
    (is (= (n146s '{m {1 [a b c] 3 nil}})
           '{[m 1] [a b c], [m 3] nil}))))

(deftest clojure-147-test
  (testing "4clj n147"
    (is (= (second (n147 [2 3 2])) [2 5 5 2]))
    (is (= (take 5 (n147 [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]]))
    (is (= (take 2 (n147 [3 1 2])) [[3 1 2] [3 4 3 2]]))
    (is (= (take 100 (n147 [2 4 2])) (rest (take 101 (n147 [2 2])))))))

(deftest clojure-148-test
  (testing "4clj n148"
    (is (= 0 (n148 3 17 11)))
    (is (= 23 (n148 10 3 5)))
    (is (= 233168 (n148 1000 3 5)))
    (is (= "2333333316666668" (str (n148 100000000 3 5))))
    (is (= "110389610389889610389610"
           (str (n148 (* 10000 10000 10000) 7 11))))
    (is (= "1277732511922987429116"
           (str (n148 (* 10000 10000 10000) 757 809))))
    (is (= "4530161696788274281"
           (str (n148 (* 10000 10000 1000) 1597 3571))))))

(deftest clojure-150-test
  (testing "4clj n150"
    (is (= (take 26 (n150 0))
           [0 1 2 3 4 5 6 7 8 9
            11 22 33 44 55 66 77 88 99
            101 111 121 131 141 151 161]) )
    (is (= (take 16 (n150 162))
           [171 181 191 202
            212 222 232 242
            252 262 272 282
            292 303 313 323]) )
    (is (= (take 6 (n150 1234550000))
           [1234554321 1234664321 1234774321
            1234884321 1234994321 1235005321]) )
    (is (= (first (n150 (* 111111111 111111111)))
           (* 111111111 111111111)) )
    (is (= (set (take 199 (n150 0)))
           (set (map #(first (n150 %)) (range 0 10000)))) )
    (is (= true
           (apply < (take 6666 (n150 9999999)))) )
    (is (= (nth (n150 0) 10101)
           9102019) )))

(deftest clojure-153-test
  (testing "n153"
    (is (= (n153 #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
           true))
    (is (= (n153 #{#{:a :b :c :d :e}
                   #{:a :b :c :d}
                   #{:a :b :c}
                   #{:a :b}
                   #{:a}})
           false))
    (is (= (n153 #{#{[1 2 3] [4 5]}
                   #{[1 2] [3 4 5]}
                   #{[1] [2] 3 4 5}
                   #{1 2 [3 4] [5]}})
           true))
    (is (= (n153 #{#{'a 'b}
                   #{'c 'd 'e}
                   #{'f 'g 'h 'i}
                   #{''a ''c ''f}})
           true))
    (is (= (n153 #{#{'(:x :y :z) '(:x :y) '(:z) '()}
                   #{#{:x :y :z} #{:x :y} #{:z} #{}}
                   #{'[:x :y :z] [:x :y] [:z] [] {}}})
           false))
    (is (= (n153 #{#{(= "true") false}
                   #{:yes :no}
                   #{(class 1) 0}
                   #{(symbol "true") 'false}
                   #{(keyword "yes") ::no}
                   #{(class '1) (int \0)}})
           false))
    (is (= (n153 #{#{distinct?}
                   #{#(-> %) #(-> %)}
                   #{#(-> %) #(-> %) #(-> %)}
                   #{#(-> %) #(-> %) #(-> %)}})
           true))
    (is (= (n153 #{#{(#(-> *)) + (quote mapcat) #_nil}
                   #{'+ '* mapcat (comment mapcat)}
                   #{(do) set contains? nil?}
                   #{#_empty?}})
           false))))

(deftest clojure-n157-test
  (testing "n157"
    (is (= (n157 [:a :b :c]) [[:a 0] [:b 1] [:c 2]]))
    (is (= (n157 [0 1 3]) '((0 0) (1 1) (3 2))))
    (is (= (n157 [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]))))

(deftest clojure-n158
  (testing "n158"
    (is (= 10 ((n158 (fn [a]
                       (fn [b]
                         (fn [c]
                           (fn [d]
                             (+ a b c d))))))
               1 2 3 4)))
    (is (= 24 ((n158 (fn [a]
                       (fn [b]
                         (fn [c]
                           (fn [d]
                             (* a b c d))))))
               1 2 3 4)))
    (is (= 25 ((n158 (fn [a]
                       (fn [b]
                         (* a b))))
               5 5)))))

(deftest clojure-n168-test
  (testing "4clj n168"
    (is (= (take 6 (map #(take 5 %) (n168 str 3 2)))
           [["32" "33" "34" "35" "36"]
            ["42" "43" "44" "45" "46"]
            ["52" "53" "54" "55" "56"]
            ["62" "63" "64" "65" "66"]
            ["72" "73" "74" "75" "76"]
            ["82" "83" "84" "85" "86"]]))
    (is (= (n168 * 3 5 5 7)
           [[15 18 21 24 27 30 33]
            [20 24 28 32 36 40 44]
            [25 30 35 40 45 50 55]
            [30 36 42 48 54 60 66]
            [35 42 49 56 63 70 77]]))
    (is (= (n168 #(/ % (inc %2)) 1 0 6 4)
           [[1/1 1/2 1/3 1/4]
            [2/1 2/2 2/3 1/2]
            [3/1 3/2 3/3 3/4]
            [4/1 4/2 4/3 4/4]
            [5/1 5/2 5/3 5/4]
            [6/1 6/2 6/3 6/4]]))
    (is (= (class (n168 (juxt bit-or bit-xor)))
           (class (n168 (juxt quot mod) 13 21))
           (class (lazy-seq))))
    (is (= (class (nth (n168 (constantly 10946)) 34))
           (class (nth (n168 (constantly 0) 5 8) 55))
           (class (lazy-seq))))
    (is (= (let [m 377 n 610 w 987
                 check (fn [f s] (every? true? (map-indexed f s)))
                 row (take w (nth (n168 vector) m))
                 column (take w (map first (n168 vector m n)))
                 diagonal (map-indexed #(nth %2 %) (n168 vector m n w w))]
             (and (check #(= %2 [m %]) row)
                  (check #(= %2 [(+ m %) n]) column)
                  (check #(= %2 [(+ m %) (+ n %)]) diagonal)))
           true))))

(deftest clojure-n166-test
  (testing "4clj n166"
    (is (= :gt (n166 < 5 1)))
    (is (= :eq (n166 (fn [x y] (< (count x) (count y))) "pear" "plum")))
    (is (= :lt (n166 (fn [x y] (< (mod x 5) (mod y 5))) 21 3)))
    (is (= :gt (n166 > 0 2)))))

(deftest clojure-n171-test
  (testing "4clj n171"
    (is (= (n171 [1 2 3]) [[1 3]]))
    (is (= (n171 [10 9 8 1 2 3]) [[1 3] [8 10]]))
    (is (= (n171 [1 1 1 1 1 1 1]) [[1 1]]))
    (is (= (n171 []) []))
    (is (= (n171 [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
           [[1 4] [6 6] [9 11] [13 17] [19 19]]))))

(deftest clojure-n177-test
  (testing "4clj n177"
    (is (n177 "This string has no brackets."))
    (is (n177 "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }"))
    (is (not (n177 "(start, end]")))
    (is (not (n177 "())")))
    (is (not (n177 "[ { ] } ")))
    (is (n177 "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))"))
    (is (not (n177 "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))")))
    (is (not (n177 "[")))))

(deftest clojure-n195-test
  (testing "4clj n195"
    (is (= [#{""} #{"()"} #{"()()" "(())"}] (map (fn [n] (n195 n)) [0 1 2])))
    (is (= #{"((()))" "()()()" "()(())" "(())()" "(()())"} (n195 3)))
    (is (= 16796 (count (n195 10))))
    (is (= (nth (sort (filter #(.contains ^String % "(()()()())") (n195 9))) 6) "(((()()()())(())))"))
    (is (= (nth (sort (n195 12)) 5000) "(((((()()()()()))))(()))"))))

(deftest folding-paper-test
  (testing "folding-paper"
    (is (= '(0) (folding-paper 0)))
    (is (= '(0 0 1) (folding-paper 1)))
    (is (= '(0 0 1 0 0 1 1) (folding-paper 2)))
    (is (= '(0 0 1 0 0 1 1 0 0 0 1 1 0 1 1) (folding-paper 3)))))
