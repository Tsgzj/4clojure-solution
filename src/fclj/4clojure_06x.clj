(ns fclj.4clojure-06x)

(defn n61
  "map construction"
  [k v]
  (apply hash-map (interleave k v)))

(defn n62
  "Iterate"
  [f x]
  (lazy-seq
   (cons x (n62 f (f x)))))

(defn n63
  "Group a sequence"
  [func coll]
  (into {}
        (map #(vector (func (first %))
                    (vec %))
             (partition-by func (sort coll)))))

(defn n66
  "gcd"
  [a b]
  (if (= 0 b)
    a
    (n66 b (mod a b))))
