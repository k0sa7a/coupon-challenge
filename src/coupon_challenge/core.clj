(ns coupon-challenge.core)

(defstruct car :CarBrand :CarPrice)

(def bmwCar (struct car "bmw" 60000))
(def ferrariCar (struct car "ferrari" 100000))
(def fiat (struct car "fiat" 20000))

;(println  (:CarPrice bmwCar)  )

(def validCoupons [1234 9000 7777])

(defn checkCoupon
  [coupon]
  (contains? (set validCoupons) coupon))


(defn calculatePrice
  [budget valid]

  (if valid
    (do (println "valid 1")
        (println "valid 2")
        "VALID")

    (do (println "invalid 1")
        (println "invalid 2")
        "INVALID")

    )

  )




(defn -main
  [budget coupon]

  (def checkBool (checkCoupon coupon))
  (def result (calculatePrice budget checkBool) )
  (println result)

  )



(println "Valid Coupon; budget 50000 should return BMW 48k and FIAT 16k")
(-main 50000 1234)


(println "Invalid Coupon; budget 50000 should return invalid coupon and FIAT 20k")
(-main 50000 9999)