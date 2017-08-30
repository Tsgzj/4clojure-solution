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

;; Recursion won't work here
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; (defn n101                                       ;;
;;   [i j]                                          ;;
;;   (if (= 0 (min (count i) (count j)))            ;;
;;     (max (count i) (count j))                    ;;
;;     (let [cost (if (= (first i) (first j)) 0 1)] ;;
;;       (min (inc (n101 (rest i) j))               ;;
;;            (inc (n101 i (rest j)))               ;;
;;            (+ cost (n101 (rest i) (rest j))))))) ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn n102
  "intoCamelCase"
  [s]
  (let [l (clojure.string/split s #"-")]
    (apply str
           (first l)
           (map clojure.string/capitalize
                (rest l)))))

(defn n103
  "k-combination"
  [n c]
  (set (filter #(= n (count %))
               (reduce (fn [a x]
                         (set (concat a (map #(set (concat #{x} %)) a))))
                       #{#{}} c))))


(defn n105-wrong
  "keys and values"
  [l]
  (if (= 0 (count l))
    {}
    (let [p (partition-by keyword? l)
          d (partition 2 p)]
      (apply merge
             (flatten
              (map (fn
                     [x]
                     (map #(hash-map % (second x)) (first x)))
                   d))))))

(defn n105
  "keys and values"
  [l]
  (if (= 0 (count l))
    {}
    (let [p (partition-by keyword? l)
          d (partition 2 p)]
      (apply merge
             (flatten
              (map (fn
                     [x]
                     (let [k (reverse (first x))
                           v (second x)]
                       (if (= (count k) 1)
                         (hash-map (first k) v)
                         (zipmap k (concat (list v)
                                           (repeat (- (count k) 1) '()))))))
                   d))))))

(defn n105-better
  "keys and values"
  [l]
  (apply hash-map
         (map #(if (keyword? (first %))
                 (first %)
                 (remove nil? %))
              (partition-by keyword? (interpose nil l)))))

(defn n107
  [a]
  (letfn
   [(power [n x]
      (apply * (repeat n x)))]
    (partial power a)))

(defn n108
  "Lazy Searching"
  [& args]
  (let [ls (sort-by first args)]
    (if (apply = (map first ls))
      (first (first ls))
      (apply n108 (conj (rest ls) (rest (first ls)))))))
