(ns hello_world.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as EventType])
  (:import goog.History))

(enable-console-print!)

(def app-state (atom {:current-page nil
                      "name" "Carolina"
                      "hello" "world"}))

(defn set-current-page! [page]
  (swap! app-state assoc :current-page page))

(defn page1 []
  [:div "I am page 1"
   [:a {:href "#"
        :on-click #(set-current-page! page2)} "go to page 2"]])

(defn page2 []
  [:div "I am page 2"
   [:a {:href "#"
        :on-click #(set-current-page! page1)} "go to page 1"]])

; set current page to page1
(set-current-page! page1)

(defn simple-component []
  [(@app-state :current-page)])

; (. js/console (log (class app-state)))
; (. js/console (log "Hello world!"))
(reagent/render-component [simple-component]
                             (.getElementById js/document "app"))


;------------------------------------------------------------------------------


;; Quick and dirty history configuration.
;(let [h (History.)]
;  (goog.events/listen h EventType/NAVIGATE #(secretary/dispatch! (.-token %)))
;  (doto h (.setEnabled true)))