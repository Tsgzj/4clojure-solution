(ns fclj.4clojure-13x)

(defn n130
  "Tree reparenting"
  [node tree]
  ;; find the path to the node
  ;; rotate each element on the path
  )

(defn findpath [node tree path]
  (if (empty? tree)
    path
    (if (= node (first tree))
      path
      (let [path (conj path (first tree))]
        (findpath node (first (rest tree)) path)
        (findpath node (second (rest tree)) path)))))

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

(defn n138
  [i j]
  (letfn [(lst [x y]
            (if (> x y)
              nil
              (cons x (lst (* x x) y))))
          (sqr [n]
            (map #(clojure.string/join
                   (concat (repeat (Math/abs (- % n)) " ")
                           (repeat (- n (Math/abs (- % n))) "*")
                           (repeat (Math/abs (- % n)) " ")))
                 (range 1 (* n 2))))
          (slice [l i]
            (if (= (count l) (count i))
                   l
                   (cons (take (first i) l)
                         (slice (drop (first i) l) (rest i)))))]
    (let [d (mapcat str (lst i j))
          l (count d)
          e (int (Math/ceil (Math/sqrt l)))
          raw (concat d (drop l (repeat (#(* % %) e) \*)))]
      (slice raw (take (dec (* e 2)) (mapcat #(repeat 2 %) (iterate inc 1)))))))
