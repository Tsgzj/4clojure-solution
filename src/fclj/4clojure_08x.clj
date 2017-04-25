(ns fclj.4clojure-08x
  [:require [clojure.set :refer :all]])

(defn n80
  "Perfect Numbers"
  [n]
  (= n
     (apply + (filter #(= 0 (mod n %)) (range 1 n)))))

(defn n81
  [a b]
  (set (filter a b)))

(defn n81-set-theory
  "Set Intersection
    (A∪B∖A)∖B
    Does not apply here"
  [a b]
  (let [u (union a b)]
    (difference u (difference u a) (difference u b))))

(defn n83
  "Half truth"
  [& args]
  (not (apply = args)))

(defn n88
  [a b]
  (set
   (concat (filter (complement a) b)
           (filter (complement b) a))))
