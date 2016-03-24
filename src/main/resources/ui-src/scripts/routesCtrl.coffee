app = angular.module('routes', []);

# Random content - should be deleted soon
content = "I markup to Lorem ipsum dolor sit amet, consectetur adipisitaque sunt, illo incidunt nemo, perspiciatis minus? ffectively."

class Route
	constructor: (@title, @price, @description, image) ->
		@image = "../imgs/trips/" + image

app.controller 'routesCtrl', ($scope) ->

	$scope.purchases = 0
	$scope.currentCard = 0
	nextToDelete = 0

	$scope.trips = [
		new Route("Tibet", 1200, content, "tibet.jpg"),
		new Route("Everest", 3400, content, "everest.jpg"),
		new Route("Cuba", 900, content, "cuba.jpg"),
		new Route("Egypt", 980, content, "egypt.jpg"),
		new Route("Paris", 720, content, "paris.jpg"),
		new Route("Hawaii", 1320, content, "hawaii-island.jpg")
	]

	$scope.delete = (index) ->
		nextToDelete = index
		$('#delete').leanModal()
		return

	$scope.edit = (index) ->
		$('#edit').leanModal()
		return

	$scope.add = (index) ->
		return

	$('#yes').click ->
		$scope.trips.splice(nextToDelete, 1)
		return

#End of controller

$('.tooltipped').tooltip {delay: 50}
$('.modal-trigger').leanModal()