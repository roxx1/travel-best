var Route, app, content;

app = angular.module('trips', []);

content = "I markup to Lorem ipsum dolor sit amet, consectetur adipisitaque sunt, illo incidunt nemo, perspiciatis minus? ffectively.";

Route = (function() {
  function Route(title, price, description, image) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.image = "imgs/trips/" + image;
  }

  return Route;

})();

app.controller('tripsCtrl', function($scope) {
  $scope.purchases = 0;
  $scope.currentCard = 0;
  $scope.trips = [new Route("Tibet", 1200, content, "tibet.jpg"), new Route("Everest", 3400, content, "everest.jpg"), new Route("Cuba", 900, content, "cuba.jpg"), new Route("Egypt", 980, content, "egypt.jpg"), new Route("Paris", 720, content, "paris.jpg"), new Route("Hawaii", 1320, content, "hawaii-island.jpg")];
  $scope.buyNow = function(index) {
    $scope.currentCard = index;
    $("#buy-now").openModal();
  };
  $scope.addToShoppingCard = function() {
    return $scope.purchases++;
  };
  $scope.showPurchases = function() {
    return $scope.purchases > 0;
  };
  return $scope.purchaseSubmit = function() {
    $("#buy-now").closeModal();
    return $scope.purchases++;
  };
});
