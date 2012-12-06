(ns api-quiz.fibonacci)

(defn fib-iter [n]
  (if (< n 3) 1
    (loop [x (biginteger 1), y 1, z 2, counter (- n  3)]
      (if (= 0 counter) z
        (recur y z (+ y z) (dec counter))))))