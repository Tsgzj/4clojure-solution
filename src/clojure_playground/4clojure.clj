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

(defn n27
  "https://www.4clojure.com/problem/27#prob-title Palindrome Detector"
  [x]
  (= (seq x) (reverse x)))
;; seq "racecar" retuerns '(\r \a \c \e \c \a \r)
