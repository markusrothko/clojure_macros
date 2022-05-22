(ns inlämning2.core)

(import java.io.FileReader java.io.File)
(import  java.io.Closeable)



(defmacro safe
  ([expression]
    `(try ~expression
      (catch Exception e#
        (println e#))))
  ([vecArgs & expression]
    `(try ~vecArgs ~@expression
      (catch Exception e#
        (println e#))))
)

(def v (safe (/ 1 0)))
(def v (safe (/ 10 2)))
(def v (safe [s (FileReader. (File. "file.txt"))] (.read s)))
(def v (safe [s (FileReader. (File. "missing-file"))] (. s read)))