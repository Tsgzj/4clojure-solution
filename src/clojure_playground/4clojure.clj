(ns clojure-playground.4clojure)

(defn n27
  "https://www.4clojure.com/problem/27#prob-title Palindrome Detector"
  [x]
  (= (seq x) (reverse x)))
;; seq "racecar" retuerns '(\r \a \c \e \c \a \r)
