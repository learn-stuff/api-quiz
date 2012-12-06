(ns api-quiz.core
 (:gen-class)
 (:use api-quiz.fibonacci)
 (:use api-quiz.page-sha1)
 (:use api-quiz.storage)
 (:use compojure.core)
 (:use ring.adapter.jetty)
 (:use [ring.middleware.params :only [wrap-params]])
 (:require [compojure.route :as route]
           [clojure.data.json :as json])
 (:import [java.io File]))
 
(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/write-str {:response data})})

(defroutes api-routes
  (GET "/" [] {:status 200})
  (GET ["/fib/:num", :num #"[0-9]+"] [num] (json-response (fib-iter (biginteger num))))
  (GET "/google-body" [] (json-response (sha1 (fetch-url "http://google.com"))))
  (GET "/store" [] (json-response (get-last)))
  (POST "/store" { params :params }
        (do
          (store-value (params "val"))
          (json-response :ok)))
  (route/not-found "Page not found"))

(def app (wrap-params api-routes))

(defn -main [& args]
  (if (not (.exists (File. db-name))) (create-db))
  (run-jetty app {:port 8080}))