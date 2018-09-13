#lang racket

(define (sieve-of-E x)
  (sieve-of-E-helper x '()))

(define (sieve-of-E-helper x primes)
  (if (null? x)
      primes
      (sieve-of-E-helper (filter (lambda (cur)
                                   (not (= 0 (modulo cur (car x)))))
                                 (cdr x))
                         (append primes (list (car x))))))
