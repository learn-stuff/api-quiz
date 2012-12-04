(ns api-quiz.core
 (:gen-class)
 (:use compojure.core)
 (:use ring.adapter.jetty)
 (:use api-quiz.fibonacci)
 (:use api-quiz.sha1)
 (:require [compojure.route :as route]
           [clojure.data.json :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/write-str {:response data})})

(defroutes api-routes
  (GET "/" [] {:status 200})
  (GET "/fib/:num" [num] (json-response (fib-iter (biginteger num))))
  (POST "/store/:val" [val] (str "post test val was " val))
  (route/not-found "Page not found"))

(defn -main [& args]
  (run-jetty api-routes {:port 8080}))