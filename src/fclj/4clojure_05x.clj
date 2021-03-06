(ns fclj.4clojure-05x)

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

(defn n54
  "Partition a Sequence"
  [n lst]
  (if (> n (count lst))
    []
    (cons (take n lst) (n54 n (drop n lst)))))

;;  (defn n53
;;    "Longest Increasing Sub-seq"
;;    [lst]
;;    (let [a (partition-by #(apply < %) (partition 2 1 lst))
;;          b (filter (fn [[[a b]]] (< a b)) a)
;;          c (first (sort-by count > b))]
;;      (cons (ffirst c) (map second c))))

(defn n55
  "Count Occurences"
  [lst]
  (into {}
        (map (fn [[k v]] [k (count v)]) (group-by identity lst))))

(defn n56
  "Find distinct items. Note group-by does not work here since it implements hash-map
  if the number of elements is over 32"
  [lst]
  (reduce
   (fn [coll e]
     (if (some #(= % e) coll)
       coll
       (conj coll e)))
   []
   lst))

(defn n58
  "Function Composition"
  [& f]
  (fn [& args]
    (reduce #(%2 %)
            (apply (last f) args)
            (rest (reverse f)))))

(#(apply hash-map
         ((fn f [e h]
            (if (= 1 (count h))
              [(first h) e]
              (concat [(first h) e] (f e (rest h)))))
          % %2)) 1 '(1 2 3))

(defn n59
  [& fs]
  (fn [& args]
    (map #(apply % args) fs)))
