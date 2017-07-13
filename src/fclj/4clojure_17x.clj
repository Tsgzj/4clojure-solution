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
