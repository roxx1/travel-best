app = angular.module('edit-trips', [])

class Trip
	constructor: (@id, @route) ->

app.controller 'editTripsCtrl', ($scope) -> 
	$scope.trips = [
		new Trip(1, 1)
		new Trip(2, 2)
	]