 (ns fclj.4clojure-15x)

(defn n150
  "Palindromic Numbers"
  [n]
  (letfn [(decode [x]
            (if (> 10 x) [x] (conj (decode (quot x 10)) (rem x 10))))
          (encode [x]
            (reduce #(+ (* 10 %) %2) x))
          (next-p [n]
            (let [N (decode n)
                  L (count N)
                  H (quot L 2)]
                ))]
    (next-p n)))

(defn n153
  "Pairwise Disjoint Set"
  [s]
  (= (apply + (map count s))
     (count (reduce clojure.set/union s))))

(defn n157
  "Indexing Sequences"
  [lst]
  (partition 2 (interleave lst (range))))

(defn n158
  "Decurry"
  [f]
  (fn [& args]
    (reduce #(% %2) f args)))
