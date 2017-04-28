(ns fclj.4clojure-11x)

(defn n115
  "The balance of N"
  [n]
  (let [s (str n)
        c (/ (count s) 2)
        l (take c s)
        r (take c (reverse s))]
    ;; The integer does not to be the same as it shows
    ;; as long as they are converted
    (= (apply + (map int l))
       (apply + (map int r)))))

(defn n118-not-working
  "Re-implement Map"
  [f s]
   (reduce (fn [lst e]
             (cons (f e) lst))
           []
           (reverse s)))

(defn n118
  "Re-umplement Map"
  [f s]
  (if (not (empty? s))
    (lazy-seq
     (cons (f (first s))
           (n118 f (rest s))))))
