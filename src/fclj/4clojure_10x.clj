(ns fclj.4clojure-10x)

(defn n100
  [a & args]
  (letfn [(gcd [a b]
            (cond
              (= a b) a
              (< a b) (gcd a (- b a))
              (> a b) (gcd (- a b) b)))
          (lcm [a b]
            (/ (* a b) (gcd a b)))]
    (reduce lcm a args)))

(defn n102
  "intoCamelCase"
  [s]
  (let [l (clojure.string/split s #"-")]
    (apply str
           (first l)
           (map clojure.string/capitalize
                (rest l)))))

(defn n107
  [a]
  (letfn
      [(power [n x]
         (apply * (repeat n x)))]
    (partial power a)))
