(ns fclj.4clojure-11x)

(defn n110
  "Sequence of pronunciations"
  [s]
  (letfn [(pro [seq]
            (mapcat
             (fn
               [l]
               [(count l) (first l)])
             (partition-by identity seq)))]
    (rest (iterate pro s))))

(defn n112
  "Seques Horribilis"
  [n s])

(defn n114
  "Global take-while"
  [n p s]
  (loop [n n s s r []]
    (if (= 0 n)
      (butlast r)
      (if (p (first s))
        (recur (dec n)
               (rest s)
               (conj r (first s)))
        (recur n
               (rest s)
               (conj r (first s)))))))

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

(defn n116
  "Prime Sandwich"
  [n]
  (letfn [(prime? [x]
            (if (= x 1)
              false
              (not-any? #(= 0 (mod x %))
                        (range 2 x))))]
    (if ((complement prime?) n)
      false
      (= n
         (/ (+ (first (filter prime? (iterate inc (+ n 1))))
               (first (filter prime? (iterate dec (- n 1)))))
            2)))))

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
