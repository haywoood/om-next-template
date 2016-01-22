(ns leiningen.new.om-next
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "om-next"))

(defn om-next
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' om-next project.")
    (->files data
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["project.clj" (render "project.clj" data)]
             ["script/figwheel.clj" (render "figwheel.clj" data)]
             ["resources/public/index.html" (render "index.html" data)])))
