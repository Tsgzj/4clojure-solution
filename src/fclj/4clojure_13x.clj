(ns fclj.4clojure-13x)

(defn n131
  [& x]
  (if (== 1 (count x))
    true
    (letfn [(ps [s]
              (remove empty?
                      (reduce (fn [sets el]
                                (into sets
                                      (map #(conj % el) sets)))
                              #{#{}} s)))]
      (not
       (empty?
        (apply clojure.set/intersection
               (map
                (fn [a]
                  (set (map #(reduce + %) (ps a))))
                x)))))))

(defn n132
  "Insert between two items"
  [f v l]
  (if (empty? l)
    '()
    (cons (first l)
          (mapcat #(rest (if (apply f %) (interpose v %) %))
                  (partition 2 1 l)))))

(defn t [p v xs]
  (mapcat
   #(if (p %1 %2) [%1 v] [%1])
   xs
   (lazy-cat (rest xs) (take 1 xs))))

(defn n135
  [val & args]
  (reduce
   (fn
     [a [f b]]
     (f a b))
   val
   (partition 2 args)))

(defn n137
  "Digits and bases"
  [n b]
  (if (< n b)
    [(rem n b)]
    (conj (n137 (quot n b) b) (rem n b))))

(defn n137-recur
  [n b]
  (loop [a (quot n b)
         b b
         r [(rem n b)]]
    (if (zero? a)
      r
      (recur (quot a b) b (cons (rem a b) r)))))
