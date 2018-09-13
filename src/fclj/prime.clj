(ns fclj.prime)

(defn is-prime? [n]
  (not-any? #(== (mod n %) 0) (range 2 (Math/sqrt n))))

(defn naive-prime [x]
  ;; x is a list of numbers
  (filter is-prime? x))

;; (defn sieve-of-E-helper [x primes]
;;   ;; Eratosthenes Sieve
;;   ;; on need to use the helper function
;;   (if (empty? x)
;;     primes
;;     (do
;;       (recur (filter #(not= 0 (mod % (first x)))
;;                      (rest x))
;;              (conj primes (first x))))))

(defn sieve-of-E [x]
  ;; Eratosthenes Sieve
  (loop [lst (range 2 x)
         primes []]
    (if (empty? lst)
      primes
      (recur (filter #(not= 0 (mod % (first lst)))
                     (rest lst))
             (conj primes (first lst))))))

(defn sieve-of-E-lazy [x]
  (letfn [(helper [lst]
            (cons (first lst)
                  (lazy-seq (helper (filter #(not= 0 (mod % (first lst)))
                                                     (rest lst))))))]
    (helper (range 2 x))))

(defn sieve-of-A
  ;; Atkin Sieve
  ;; Source http://www.ams.org/journals/mcom/2004-73-246/S0025-5718-03-01501-1/S0025-5718-03-01501-1.pdf
  ([x]
   (sieve-of-A x []))
  ([x primes]
   ;; TODO: add sieve-of-A implementation here
   ))
