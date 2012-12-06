(ns api-quiz.fibonacci)

(defn fib-iter [n]
  (if (< n 3) 1
    (loop [x (biginteger 1), y 2, counter (- n  3)]
      (if (= 0 counter) y
        (recur y (+ x y) (dec counter))))))