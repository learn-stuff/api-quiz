(ns api-quiz.core
 (:gen-class)
 (:use compojure.core)
 (:use ring.adapter.jetty)
 (:require [compojure.route :as route]))

(defroutes api-routes
  (GET "/" [] {:status 200})
  (GET "/fib/:num" [num] (str num))
  (POST "/store/:val" [val] (str "post test val was " val))
  (route/not-found "Page not found"))

(defn -main [& args]
  (run-jetty api-routes {:port 8080}))