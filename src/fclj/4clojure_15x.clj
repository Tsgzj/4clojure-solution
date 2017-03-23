(ns fclj.4clojure-15x)

(defn n157
  "Indexing Sequences"
  [lst]
  (partition 2 (interleave lst (range))))
