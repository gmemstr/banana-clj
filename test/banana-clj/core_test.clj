(ns banana-clj.core-test
	(:require [clojure.test :refer :all]
		[banana-clj.core :refer :all]))

(deftest grow-test
	(testing "Growing a banana."
		(is (= "bannaannnannannanannaananannannan" (grow-banana "gmem"))))
)

(deftest peel-test
	(testing "Peeling a banana."
		(is (= "gmem" (peel-banana "bannaannnannannanannaananannannan"))))
)
