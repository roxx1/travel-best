app = angular.module('orders', [])

class Order
	constructor: (@image, @title, @price, @endDate, @payDate, @tourists, @rejected, @returned) ->

app.controller 'ordersCtrl', ($scope) ->
	$scope.orders = [
		new Order("../imgs/trips/tibet.jpg", "Tibet", 2000, '2016/03/20', '2016/03/28', 7, no, no),
		new Order("../imgs/trips/cuba.jpg", "Cuba", 900, '2016/06/20', '2016/06/28', 2, no, no),
	]
	
	$scope.ordersInShoppingCard = [
		new Order("../imgs/trips/egypt.jpg", "Everest", 3700, '2016/03/20', '2016/03/28', 7, no, no),
		new Order("../imgs/trips/hawaii-island.jpg", "Hawaii", 900, '2016/06/20', '2016/06/28', 2, no, no),
	]
