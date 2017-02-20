(ns clojure-playground.4clojure_03x)

(defn n30
  "https://www.4clojure.com/problem/30 Compress a seq"
  [x]
  (map first (partition-by identity x)))

(defn n32
  "https://www.4clojure.com/problem/32 Duplicate Seq"
  [x]
  (mapcat #(conj '() % %) x))

(defn n33
  "https://www.4clojure.com/problem/33#prob-title Replica Sequence"
  [lst n]
  (mapcat #(repeat n %) lst))

(defn n34
  "https://www.4clojure.com/problem/34#prob-title Range"
  [start end]
  (letfn [(range-helper [start end lst]
            (if (= start end)
              lst
              (range-helper (inc start) end (conj lst start))))]
    (range-helper start end [])))

(defn n38
  "https://www.4clojure.com/problem/38 Maximum Value"
  [& arg] (reduce (fn [x y] (if (> x y) x y)) arg))
