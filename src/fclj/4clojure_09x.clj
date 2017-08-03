(ns fclj.4clojure-09x)

(defn n90
  "Cartesion Product"
  [a b]
  (set
   (for [x a
         y b]
     [x y])))

(defn n93
  "Partially flatten"
  [l]
  (if (some (complement coll?) l)
    [l]
    (mapcat n93 l)))

(defn n95
  "To tree or not to tree"
  [root]
  (or (nil? root)
      (and (sequential? root)
           (= 3 (count root))
           (and (n95 (second root))
                (n95 (last root))))))

(defn n96
  "Symmentree"
  [root]
  (letfn [(rev-tree [r]
            (if (nil? r)
              r
              [(first r)
               (rev-tree (last r))
               (rev-tree (second r))]))]
    (= (second root) (rev-tree (last root)))))

(defn n97
  "Pascal's Triangle"
  [n]
  (for [x (range 1 (inc n))
        :let [y (/ (apply * (range 1 n))
                   (* (apply * (range 1 x))
                      (apply * (range 1 (inc (- n x))))))]]
    y))

(defn n97-v2
  [n]
  (cond
    (= n 1) [1]
    (= n 2) [1 1]
    :else (concat [1]
                  (map #(+ (first %) (second %))
                       (partition 2 1 (n97-v2 (dec n))))
                  [1])))

(defn n98
  "Equivalence Classes"
  [f D]
  (let [r (map f D)
        t (partition 2 (interleave D r))
        p (group-by #(second %) t)]
    (into #{}
          (map #(into #{} (map first (second %))) p))))

(defn n98-v2
  [f D]
  (set (map set (vals (group-by f D)))))

(defn n99
  "Product Digits"
  [a b]
  (let [res (* a b)]
    (letfn [(pd [x]
              (if (< x 10)
                [x]
                (cons (mod x 10) (pd (quot x 10)))))]
      (reverse (pd res)))))

(defn n99-low-golf
  [a b]
  (->> (* a b)
       str
       seq
       (map str)
       (map read-string)))
