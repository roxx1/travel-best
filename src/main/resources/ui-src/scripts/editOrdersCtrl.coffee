app = angular.module('edit-orders', [])

class Order
	constructor: (@id, @trip, @customer, @price, @paymentSystem, @payDate, @rejected, @returned) ->

app.controller "editOrdersCtrl", ($scope) ->
	$scope.orders = [
		new Order(1, "Everest", "Vasya Pupkin", 3700, "PayPal", "2016/03/20", no, no),
		new Order(2, "Tibet", "John Smith", 1800, "Local Bank", "2015/02/20", yes, no),
		new Order(3, "Hawaii", "Vasya Pupkin", 1100, "PayPal", "2016/10/21", no, no),
		new Order(4, "Cuba", "John Smith", 900, "PayPal", "2016/03/02", no, yes),
		new Order(5, "Paris", "Robert Martin", 1200, "PayPal", "2012/03/20", no, no),
		new Order(6, "Everest", "Sally Osborne", 3700, "PayPal", "2010/03/20", no, no),
		new Order(7, "Tibet", "Vasya Pupkin", 1800, "PayPal", "2010/03/20", yes, no),
		new Order(8, "Cuba", "Yan Chan", 900, "PayPal", "2016/03/21", no, no)
	]

	$scope.isRejected = (index) -> $scope.orders[index].rejected ? "yes" : "no"
	$scope.isReturned = (index) -> $scope.orders[index].returned ? "yes" : "no"