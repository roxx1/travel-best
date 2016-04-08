app = angular.module('trips', []);

# Random content - should be deleted soon
tibetContent = "Tibet is an exotic place, a land of ancient Buddhist culture, centuries old monasteries and uniquely beautiful desert terrain."
everestContent = "For most people, Everest is a once in a lifetime experience because of the costs, the time invested, etc."
cubaContent = "Vacation packages to Cuba are the perfect fun in the sun, affordable getaways. Bask in the sun, dip in beautiful blue waters or take part in many of the great activities offered at each resort."


class Route
	constructor: (@title, @price, @description, image) ->
		@image = "imgs/trips/" + image


app.controller 'tripsCtrl', ($scope) ->

	$scope.purchases = 0
	$scope.currentCard = 0

	$scope.trips = [
		new Route("Tibet", 1200, tibetContent, "tibet.jpg"),
		new Route("Everest", 3400, everestContent, "everest.jpg"),
		new Route("Cuba", 900, cubaContent, "cuba.jpg"),
		new Route("Egypt", 980, tibetContent, "egypt.jpg"),
		new Route("Paris", 720, tibetContent, "paris.jpg"),
		new Route("Hawaii", 1320, tibetContent, "hawaii-island.jpg")
	]

	$scope.buyNow = (index) ->
		$scope.currentCard = index
		$("#buy-now").openModal()
		return

	$scope.addToShoppingCard = () ->
		$scope.purchases++

	$scope.showPurchases = () ->
		$scope.purchases > 0

	$scope.purchaseSubmit = () ->
		$("#buy-now").closeModal()
		$scope.purchases++
		
$('.tooltipped').tooltip({delay: 50})
$('select').material_select()