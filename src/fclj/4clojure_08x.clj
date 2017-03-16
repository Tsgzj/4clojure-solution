(ns fclj.4clojure-08x
  [:require [clojure.set :refer :all]])

(defn n81-set-theory
  "Set Intersection
  (A∪B∖A)∖B
  Does not apply here"
  [a b]
  (let [u (union a b)]
    (difference u (difference u a) (difference u b))))

(defn n81
  [a b]
  (set (filter a b)))

(defn n83
  "Half truth"
  [& args]
  (not (apply = args)))