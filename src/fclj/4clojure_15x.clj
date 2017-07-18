 (ns fclj.4clojure-15x)

(defn n150
  "Palindromic Numbers"
  [n]
  (letfn [(decode [x]
            (if (> 10 x) [x] (conj (decode (quot x 10)) (rem x 10))))
          (encode [x]
            (reduce #(+ (* 10 %) %2) 0 x))
          (next-p [x]
            (let [N (decode x)
                  n (count N)
                  l (quot n 2)
                  H (drop-last l N)
                  H1 (decode (inc (encode H)))
                  L (reverse (take l H))
                  L1 (reverse (take l H1))
                  res (encode (concat H L))]
              (if (>= res x)
                res
                (encode (concat H1 L1)))))]
    (iterate (comp next-p inc) (next-p n))))

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
