(ns clojure-playground.4clojure_03x)

(defn n32
  "https://www.4clojure.com/problem/32 Duplicate Seq"
  [x]
  (mapcat #(conj '() % %) x))

(defn n33
  "https://www.4clojure.com/problem/33#prob-title Replica Sequence"
  [lst n]
  (mapcat #(repeat n %) lst))

(defn n38
  "https://www.4clojure.com/problem/38 Maximum Value"
  [& arg] (reduce (fn [x y] (if (> x y) x y)) arg))
