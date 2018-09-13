(ns fclj.4clojure-17x)

(defn n171
  "Intervals"
  [c]
  (let [sc (sort c)
        t (reductions = true
                      (map #(> 2 (- %2 %)) sc (rest sc)))]
    (map #(vector (first %) (last %))
         (map #(map first %)
              (partition-by second (map list sc t))))))

(defn n177
  "Balancing Brackets"
  [c]
  (let [p {\{ \} \[ \] \( \)}]
    (letfn [(h [s
                st]
              (if (empty? s)
                (empty? st)
                (if (p (first s))
                  (h (rest s) (cons (first s) st))
                  (if (some #{(first s)} (vals p))
                    (and (= (first s) (p (first st)))
                         (h (rest s) (rest st)))
                    (h (rest s) st)))))]
      (h c []))))
