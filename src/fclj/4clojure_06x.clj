(ns fclj.4clojure-06x)

(defn n60
  "Sequence Reductions"
  ([f coll]
   (n60 f (first coll) (rest coll)))
  ([f init coll]
   (lazy-seq
    (if (empty? coll)
      (list init)
      (cons init
            (n60 f (f init (first coll))
                 (rest coll)))))))

(defn n61
  "map construction"
  [k v]
  (apply hash-map (interleave k v)))

(defn n62
  "Iterate"
  [f x]
  (lazy-seq
   (cons x (n62 f (f x)))))

(defn n63
  "Group a sequence"
  [func coll]
  (apply merge-with concat
         (map #(hash-map (func %) [%])
              coll)))

(defn n65
  "Black Box Testing
  To poke at map/set/list/vector and understand their behavior
  only vector is reversible
  we can empty all of these collections and compare
  (= '() []) ==> true, these two has to be identified with reversible?
  (= {} '()) ==> false, (= {} []) ==> false, (= #{} []) ==> false, (= #{} '()) ==> false
  (= {} #{}) ==> false"
  [x]
  ({{} :map, #{} :set} (empty x) (if (reversible? x) :vector :list)))

(defn n66
  "gcd"
  [a b]
  (if (= 0 b)
    a
    (n66 b (mod a b))))

(defn n67
  "First x prime numbers"
  [x]
  (take x
        (filter (fn [n]
                  (if (= n 2)
                    true
                    (not-any? #(= 0 (mod n %))
                              (range 2 (inc (Math/sqrt n))))))
                (iterate inc 2))))

(defn n69
  [f & maps]
  (let [K (set (mapcat keys maps))
        V (map (fn [k]
                 (vector k (filter #(not (nil? %))
                                   (map #(get % k) maps)))) K)]
    (apply hash-map
           (mapcat #(vector (first %) (reduce f (second %))) V))))
