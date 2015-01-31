;;; If this namespace requires macros, remember that ClojureScript's
;;; macros are written in Clojure and have to be referenced via the
;;; :require-macros directive where the :as keyword is required, while in Clojure is optional. Even
;;; if you can add files containing macros and compile-time only
;;; functions in the :source-paths setting of the :builds, it is
;;; strongly suggested to add them to the leiningen :source-paths.
(ns calculator.core
  (:require [reagent.core :as reagent :refer [atom]]))

(def app-state (atom {:num1 0
                      :num2 0}))

(defn set-value [number value]
  (swap! app-state assoc number value))

(set-value :num1 1)

(defn for-list []
  [:ul
    (for [day (range 31)]
      [:li day])])

(defn init []
  [:div "Hola"
   [:h1 (get-in @app-state [:num1])]
   [:button {:on-click #(set-value :num1 10) } "Change me to 10!"
    ]
   [for-list]
   ])

(reagent/render-component [init] (.getElementById js/document "app"))
