(ns coupon-challenge.core)

(defstruct car :CarBrand :CarPrice)

(def bmwCar (struct car "bmw" 60000))

(defn foo

  []
  (println bmwCar))
(foo)