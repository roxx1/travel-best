app = angular.module('routes', []);

class Route
	constructor: (@title, @destination, @description, image) ->
		@image = "../imgs/trips/" + image

description = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id inventore saepe dolorem possimus autem voluptatem eos, beatae vel voluptas unde."
destination = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis beatae culpa dolor mollitia exercitationem nostrum!"

app.controller 'routesCtrl', ($scope) ->

	$scope.purchases = 0
	$scope.currentCard = 0
	nextToDelete = 0

	$scope.trips = [
		new Route("Tibet", description, destination, "tibet.jpg"),
		new Route("Everest", description, destination, "everest.jpg"),
		new Route("Cuba", description, destination, "cuba.jpg"),
		new Route("Egypt", description, destination, "egypt.jpg"),
		new Route("Paris", description, destination, "paris.jpg"),
		new Route("Hawaii", description, destination, "hawaii-island.jpg")
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