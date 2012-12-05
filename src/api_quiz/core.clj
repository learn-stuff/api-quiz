(ns api-quiz.core
 (:gen-class)
 (:use compojure.core)
 (:use ring.adapter.jetty)
 (:use api-quiz.fibonacci)
 (:use api-quiz.page-sha1)
 (:require [compojure.route :as route]
           [clojure.data.json :as json]))
 
(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/write-str {:response data})})

(defroutes api-routes
  (GET "/" [] {:status 200})
  (GET ["/fib/:num", :num #"[0-9]+"] [num] (json-response (fib-iter (biginteger num))))
  (GET "/google-body" [] (json-response (sha1 (fetch-url "http://google.com"))))
  (POST "/store" { params :params } (json-response :ok))
  (route/not-found "Page not found"))

(defn -main [& args]
  (run-jetty api-routes {:port 8080}))