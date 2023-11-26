(ns coupon-challenge.core)

(defstruct car :CarBrand :CarPrice)

(def bmwCar (struct car "bmw" 60000))
(def ferrariCar (struct car "ferrari" 100000))
(def fiat (struct car "fiat" 20000))

(def validCoupons [1234 9000 7777])

(defn checkCoupon
  [coupon]
  (contains? (set validCoupons)  coupon))

(defn returnOptimalCar
  [budget coupon]

  (def checkBool (checkCoupon coupon))
  (println checkBool)
  )

(println "Valid Coupon; budget 50000 should return BMW 48k and FIAT 16k")

(returnOptimalCar 50000 1234)


(println "Invalid Coupon; budget 50000 should return invalid coupon and FIAT 20k")
(returnOptimalCar 50000 9999)