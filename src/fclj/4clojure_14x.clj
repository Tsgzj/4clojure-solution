(ns fclj.4clojure-14x)

(defn n141
  "Tricky card games"
  [t]
  (fn [l]
    (let [led (if t
                t
                (:suit (first l)))]
      (last (sort-by :rank
                     (filter #(= led (:suit %)) l))))))

(defn n143
  "dot product"
  [a b]
  (apply + (map * a b)))

(defn n144
  "Oscilrate"
  [n & f]
  (cons n
        (lazy-seq (apply n144
                         (cons ((first f) n)
                               (concat (rest f) (take 1 f)))))))
;; A pretty elegant solution
(defn n144-ele
  [n & f]
  (reductions #(%2 %1) n (cycle f)))

(defn n147
  "Pascal's Trapezoid"
  [p]
  (iterate #(vec (map +' (cons 0 %) (conj % 0))) p))

(defn n148
  [j k l]
  (letfn [(sum [a n]
            (/ (* n (+ a (* n a))) 2))
          (tit [x y]
            (sum x (bigint (quot (dec y) x))))]
    (- (+ (tit k j)
          (tit l j))
       (tit (* k l) j))))
