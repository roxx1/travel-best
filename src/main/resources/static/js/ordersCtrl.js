var Order, app;

app = angular.module('orders', []);

Order = (function() {
  function Order(image, title, price, endDate, payDate, tourists, rejected, returned) {
    this.image = image;
    this.title = title;
    this.price = price;
    this.endDate = endDate;
    this.payDate = payDate;
    this.tourists = tourists;
    this.rejected = rejected;
    this.returned = returned;
  }

  return Order;

})();

app.controller('ordersCtrl', function($scope) {
  $scope.orders = [new Order("../imgs/trips/tibet.jpg", "Tibet", 2000, '2016/03/20', '2016/03/28', 7, false, false), new Order("../imgs/trips/cuba.jpg", "Cuba", 900, '2016/06/20', '2016/06/28', 2, false, false)];
  return $scope.ordersInShoppingCard = [new Order("../imgs/trips/egypt.jpg", "Everest", 3700, '2016/03/20', '2016/03/28', 7, false, false), new Order("../imgs/trips/hawaii-island.jpg", "Hawaii", 900, '2016/06/20', '2016/06/28', 2, false, false)];
});
