var Trip, app;

app = angular.module('edit-trips', []);

Trip = (function() {
  function Trip(id, route) {
    this.id = id;
    this.route = route;
  }

  return Trip;

})();

app.controller('editTripsCtrl', function($scope) {
  return $scope.trips = [new Trip(1, 1), new Trip(2, 2)];
});
