app = angular.module('edit-trips', [])

class Trip
	constructor: (@id, @route, @price, @expirationDate, @startDate, @endDate, @amountOfTourists) ->

app.controller 'editTripsCtrl', ($scope) -> 
	$scope.trips = [
		new Trip(1, 1, 1200.0, new Date(), new Date(), new Date(), 10)
		new Trip(1, 2, 2250.0, new Date(), new Date(), new Date(), 12)
		new Trip(2, 1, 3100.0, new Date(), new Date(), new Date(), 20)
		new Trip(2, 3, 900.5, new Date(), new Date(), new Date(), 5)
		new Trip(2, 2, 2405.0, new Date(), new Date(), new Date(), 12)
	]