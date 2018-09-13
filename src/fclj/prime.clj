(ns fclj.prime)

(defn is-prime? [n]
  (not-any? #(== (mod n %) 0) (range 2 (Math/sqrt n))))

(defn naive-prime [x]
  ;; x is a list of numbers
  (filter is-prime? x))

(defn sieve-of-E-helper [x primes]
  ;; Eratosthenes Sieve
  (if (zero? (count x))
    primes
    (sieve-of-E-helper (filter #(not= 0 (mod % (first x)))
                               (rest x))
                       (conj primes (first x)))))

(defn sieve-of-E [x]
  (sieve-of-E-helper x []))

(defn sieve-of-E-lazy [x]
  (cons (first x)
        (lazy-seq (sieve-of-E-lazy (filter #(not= 0 (mod % (first x)))
                                             (rest x))))))

(defn sieve-of-A-helper [x primes]
  (if (zero? (count x))
    primes
    (sieve-of-A-helper ())))

(defn sieve-of-A [x]
  ;; Atkin Sieve
  ;; Source http://www.ams.org/journals/mcom/2004-73-246/S0025-5718-03-01501-1/S0025-5718-03-01501-1.pdf
  (sieve-of-A-helper x []))
