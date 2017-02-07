(ns clojure-playground.4clojure)

(defn n21
  "https://www.4clojure.com/problem/21 nth element"
  [lst n]
  (if (= n 0)
    (first lst)
    (recur (rest lst) (dec n))))

(defn n22
  "https://www.4clojure.com/problem/22#prob-title Count a sequence"
  [x]
  (letfn [(count-sequence-helper [x n]
            (if (empty? x)
              n
              (count-sequence-helper (rest x) (inc n))))]
    (count-sequence-helper x 0)))

(defn n23
  "https://www.4clojure.com/problem/23#prob-title Reverse sequence"
  [list]
  ;; notice that (conj [1 2 3] 1) return [1 2 3 1]
  ;; while (conj (1 2 3) 1) return (1 1 2 3)
  ;; it always adds the item to the most `efficient` place
  ;; this will return the sequence of same order
  ;; (reducet conj [] list)
  (reduce conj () list))

(defn n24
  "https://www.4clojure.com/problem/24#prob-title Sum it up"
  [list]
  ;; basic reduce
  (reduce + list))

(defn n27
  "https://www.4clojure.com/problem/27#prob-title Palindrome Detector"
  [x]
  (= (seq x) (reverse x)))
;; seq "racecar" retuerns '(\r \a \c \e \c \a \r)
