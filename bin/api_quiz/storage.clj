(ns api-quiz.storage
  (:use [clojure.java.jdbc])
  (:refer-clojure :exclude [resultset-seq])) ;resolve namespace conflict

(def db-name "storage.db")

(def db
  {
   :classname "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname db-name
  })

(defn create-db []
  (try (with-connection db 
         (create-table :api
                       [:data :text]))
       (catch Exception e (println e))))

(defn store-value [value]
  (with-connection db
    (insert-records :api {:data value})))

(defn get-last []
  (with-connection db
    (with-query-results rs ["select * from api"] (:data (last rs)))))