(ns kata-buying-a-car.kata-buying-a-car)

(defn nb-months
  [old new savings-per-month percent-loss-per-month]
  (if (<= new old)
    [0 (- old new)]
    (loop [percent percent-loss-per-month
           need new
           sell old
           cash 0
           months 0]
      (if (<= need (+ sell cash))
        [months (Math/round (- (+ sell cash) need))]
        (recur (if (even? months) (+ percent 0.5) percent)
               (* need (- 1 (/ percent 100)))
               (* sell (- 1 (/ percent 100)))
               (+ cash savings-per-month)
               (inc months))))))
