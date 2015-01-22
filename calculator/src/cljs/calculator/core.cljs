;;; If this namespace requires macros, remember that ClojureScript's
;;; macros are written in Clojure and have to be referenced via the
;;; :require-macros directive where the :as keyword is required, while in Clojure is optional. Even
;;; if you can add files containing macros and compile-time only
;;; functions in the :source-paths setting of the :builds, it is
;;; strongly suggested to add them to the leiningen :source-paths.
(ns calculator.core
  (:require [reagent.core :as reagent :refer [atom]]))

(def total (atom 0))

(defn foo [greeting]
  (if greeting
    (str greeting "ClojureScript!")
    (str "Hello, ClojureScript!")))

(defn textbox [name]
  [:div
  	[:input {:name name
    	       :type "text"}]])

(defn button []
  [:input {:type "submit"
           :value "Plus"
           :on-click #()}])

(defn box []
  [:div "Enter numbers: "
   [textbox "num1"]
   [textbox "num2"]
   [button]
   [:b "Total is: " @total ]])

; (.write js/document [textbox "hi"])
(reagent/render-component [box] (.getElementById js/document "app"))