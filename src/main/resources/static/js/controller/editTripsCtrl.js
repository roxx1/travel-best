var Trip, app;

app = angular.module('edit-trips', []);

Trip = (function() {
  function Trip(id, route, price, expirationDate, startDate, endDate, amountOfTourists) {
    this.id = id;
    this.route = route;
    this.price = price;
    this.expirationDate = expirationDate;
    this.startDate = startDate;
    this.endDate = endDate;
    this.amountOfTourists = amountOfTourists;
  }

  return Trip;

})();

app.controller('editTripsCtrl', function($scope) {
  return $scope.trips = [new Trip(1, 1, 1200.0, new Date(), new Date(), new Date(), 10), new Trip(1, 2, 2250.0, new Date(), new Date(), new Date(), 12), new Trip(2, 1, 3100.0, new Date(), new Date(), new Date(), 20), new Trip(2, 3, 900.5, new Date(), new Date(), new Date(), 5), new Trip(2, 2, 2405.0, new Date(), new Date(), new Date(), 12)];
});
