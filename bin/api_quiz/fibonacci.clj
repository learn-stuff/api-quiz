(ns api-quiz.fibonacci)

(defn fib-iter [n]
  (if (< n 3)
    n
    (loop [n1 (biginteger 1), n2 2, n3 3, counter (- n 3)]
      (if (= 0 counter)
        n3
        (recur n2 n3 (+ n1 n2 n3) (dec counter))))))