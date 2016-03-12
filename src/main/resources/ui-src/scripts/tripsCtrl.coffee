app = angular.module('trips', []);

# Random content - should be deleted soon
content = "I markup to Lorem ipsum dolor sit amet, consectetur adipisitaque sunt, illo incidunt nemo, perspiciatis minus? ffectively."

class Route
	constructor: (@title, @price, @description, image) ->
		@image = "imgs/trips/" + image


app.controller 'tripsCtrl', ($scope) ->

	$scope.purchases = 0
	$scope.currentCard = 0

	$scope.trips = [
		new Route("Tibet", 1200, content, "tibet.jpg"),
		new Route("Everest", 3400, content, "everest.jpg"),
		new Route("Cuba", 900, content, "cuba.jpg"),
		new Route("Egypt", 980, content, "egypt.jpg"),
		new Route("Paris", 720, content, "paris.jpg"),
		new Route("Hawaii", 1320, content, "hawaii-island.jpg")
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