(ns fclj.4clojure-07x
  (:require [clojure.string :as str]))

(defn n70
  "Word sorting"
  [s]
  (sort-by #(clojure.string/lower-case %)
           (clojure.string/split (clojure.string/replace s
                                                         #"[.!]"
                                                         "")
                                 #" ")))

(defn n74
  [s]
  (let [l (map #(Integer/valueOf %) (clojure.string/split s #","))]
    (clojure.string/join
     ","
     (filter
      (fn [n]
        (== n
            (#(* % %)
             (Math/sqrt n))))
      l))))

(defn n75
  [n]
  (if (= n 1)
    1
    (letfn
     [(gcd [a b]
        (if (= 0 b)
          a
          (gcd b (mod a b))))]
      (count
       (filter #(= 1 (gcd n %))
               (range 1 n))))))

(defn n77
  "Anagram Finder"
  [l]
  (set
   (map set
        (filter #(> (count %) 1)
                (vals (group-by sort l))))))

(defn n78
  "Reimplement Trampoline"
  [f & args]
  (loop [res (apply f args)]
    (if (fn? res)
      (recur (res))
      res)))
