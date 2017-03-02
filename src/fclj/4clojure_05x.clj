(ns fclj.4clojure_05x)

(defn n50
  "Split by type"
  [lst]
  (vals (group-by class lst)))

(defn n53
  [lst]
  "1. Get all pair of sub-string of length 2
   2. Partition all sub-strings into inc/dec group (in order)
   3. Remove those decreasing group
   4. Get the longest group, that's the longest sub-seq
   5. Re-construct the sub-seq using the group"
  (->> lst
       (partition 2 1)
       (partition-by #(apply < %))
       (filter (fn [[[a b]]] (< a b)))
       (sort-by count >)
       (first)
       (#(concat (first %) (map second (rest %))))))

;;  (defn n53
;;    "Longest Increasing Sub-seq"
;;    [lst]
;;    (let [a (partition-by #(apply < %) (partition 2 1 lst))
;;          b (filter (fn [[[a b]]] (< a b)) a)
;;          c (first (sort-by count > b))]
;;      (cons (ffirst c) (map second c))))
