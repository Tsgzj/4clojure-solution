(ns fclj.4clojure-06x)

(defn n61
  "map construction"
  [k v]
  (apply hash-map (interleave k v)))

(defn n66
  "gcd"
  [a b]
  (if (= 0 b)
    a
    (n66 b (mod a b))))
