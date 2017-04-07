(ns fclj.4clojure-12x)

(defn n120
  "Sum of square of digits"
  [coll]
  (count (filter (fn [x]
                   (let [digs (map #(- (int %) 48) (str x))]
                     (< x (reduce + (map #(* % %) digs)))))
                 coll)))

(defn n122
  "binary number
  using java integer"
  [x]
  (Integer/parseInt x 2))

(defn n128
  [str]
  (let [s-map {\H :heart, \S :spade, \D :diamond, \C :club}
        r-map {\2 0, \3 1, \4 2, \5 3, \6 4, \7 5, \8 6, \9 7, \T 8, \J 9, \Q 10, \K 11, \A 12}]
    {:suit (s-map (first str))
     :rank (r-map (second str))}))
