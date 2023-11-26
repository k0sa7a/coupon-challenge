(ns coupon-challenge.core)

(defstruct car :CarBrand :CarPrice)

(def bmwCar (struct car "bmw" 60000))
(def ferrariCar (struct car "ferrari" 100000))
(def fiatCar (struct car "fiat" 20000))



(def validCoupons [1234 9000 7777])

(defn checkCoupon
  [coupon]
  (contains? (set validCoupons) coupon))


(defn calculatePrice
  [budget valid]

  (if valid
    (do
      (cond
        (>= budget (* 0.8 (:CarPrice ferrariCar))) (* 0.8 (:CarPrice ferrariCar))
        (>= budget (* 0.8 (:CarPrice bmwCar))) (* 0.8 (:CarPrice bmwCar))
        (>= budget (* 0.8 (:CarPrice fiatCar))) (* 0.8 (:CarPrice fiatCar))
        (< budget (* 0.8 (:CarPrice fiatCar))) 0
        )


      )

    (do
      (cond
        (>= budget (:CarPrice ferrariCar)) (:CarPrice ferrariCar)
        (>= budget (:CarPrice bmwCar)) (:CarPrice bmwCar)
        (>= budget (:CarPrice fiatCar)) (:CarPrice fiatCar)
        (< budget (:CarPrice fiatCar)) 0
        )


      )

    )

  )




(defn -main
  [budget coupon]

  (def checkBool (checkCoupon coupon))
  (def result (calculatePrice budget checkBool) )
  (println "Is the coupon valid: " checkBool)
  (println (str result))
  (println "\n\n")
  )

(println "Invalid Coupon; budget 100000 should return Ferrari 100k")
(-main 100000 1234888)

(println "Valid Coupon; budget 100000 should return Ferrari 80k")
(-main 100000 1234)

(println "Valid Coupon; budget 50000 should return BMW 48k")
(-main 50000 1234)

(println "Invalid Coupon; budget 50000 should return invalid coupon and FIAT 20k")
(-main 50000 9999)

(println "Invalid Coupon; budget 19999 should return invalid coupon and 0")
(-main 1500 9999)