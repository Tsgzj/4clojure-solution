(ns fclj.4clojure-15x)

(defn n153
  "Pairwise Disjoint Set"
  [s]
  (= (apply + (map count s))
     (count (reduce clojure.set/union s))))

(defn n157
  "Indexing Sequences"
  [lst]
  (partition 2 (interleave lst (range))))
