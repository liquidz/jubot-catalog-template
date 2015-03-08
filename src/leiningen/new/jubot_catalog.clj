(ns leiningen.new.jubot-catalog
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "jubot-catalog"))

(defn jubot-catalog
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' jubot-catalog project.")
    (->files
      data
      [".gitignore"  (render ".gitignore" data)]
      ["LICENSE"     (render "LICENSE" data)]
      ["README.md"   (render "README.md" data)]
      ["project.clj" (render "project.clj" data)]
      ["src/jubot/catalog/{{sanitized}}.clj"       (render "core.clj" data)]
      ["test/jubot/catalog/{{sanitized}}_test.clj" (render "core_test.clj" data)])))
