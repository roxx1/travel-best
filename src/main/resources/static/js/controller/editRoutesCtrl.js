var Route, app, description, destination;

app = angular.module('routes', []);

Route = (function() {
  function Route(title, destination1, description1, image) {
    this.title = title;
    this.destination = destination1;
    this.description = description1;
    this.image = "../imgs/trips/" + image;
  }

  return Route;

})();

description = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id inventore saepe dolorem possimus autem voluptatem eos, beatae vel voluptas unde.";

destination = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis beatae culpa dolor mollitia exercitationem nostrum!";

app.controller('routesCtrl', function($scope) {
  var nextToDelete;
  $scope.purchases = 0;
  $scope.currentCard = 0;
  nextToDelete = 0;
  $scope.trips = [new Route("Tibet", description, destination, "tibet.jpg"), new Route("Everest", description, destination, "everest.jpg"), new Route("Cuba", description, destination, "cuba.jpg"), new Route("Egypt", description, destination, "egypt.jpg"), new Route("Paris", description, destination, "paris.jpg"), new Route("Hawaii", description, destination, "hawaii-island.jpg")];
  $scope["delete"] = function(index) {
    nextToDelete = index;
    $('#delete').leanModal();
  };
  $scope.edit = function(index) {
    $('#edit').leanModal();
  };
  $scope.add = function(index) {};
  return $('#yes').click(function() {
    $scope.trips.splice(nextToDelete, 1);
  });
});

$('.tooltipped').tooltip({
  delay: 50
});

$('.modal-trigger').leanModal();
