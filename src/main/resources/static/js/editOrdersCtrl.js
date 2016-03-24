var Order, app;

app = angular.module('edit-orders', []);

Order = (function() {
  function Order(id, trip, customer, price, paymentSystem, payDate, rejected, returned) {
    this.id = id;
    this.trip = trip;
    this.customer = customer;
    this.price = price;
    this.paymentSystem = paymentSystem;
    this.payDate = payDate;
    this.rejected = rejected;
    this.returned = returned;
  }

  return Order;

})();

app.controller("editOrdersCtrl", function($scope) {
  $scope.orders = [new Order(1, "Everest", "Vasya Pupkin", 3700, "PayPal", "2016/03/20", false, false), new Order(2, "Tibet", "John Smith", 1800, "Local Bank", "2015/02/20", true, false), new Order(3, "Hawaii", "Vasya Pupkin", 1100, "PayPal", "2016/10/21", false, false), new Order(4, "Cuba", "John Smith", 900, "PayPal", "2016/03/02", false, true), new Order(5, "Paris", "Robert Martin", 1200, "PayPal", "2012/03/20", false, false), new Order(6, "Everest", "Sally Osborne", 3700, "PayPal", "2010/03/20", false, false), new Order(7, "Tibet", "Vasya Pupkin", 1800, "PayPal", "2010/03/20", true, false), new Order(8, "Cuba", "Yan Chan", 900, "PayPal", "2016/03/21", false, false)];
  $scope.isRejected = function(index) {
    var ref;
    return (ref = $scope.orders[index].rejected) != null ? ref : {
      "yes": "no"
    };
  };
  return $scope.isReturned = function(index) {
    var ref;
    return (ref = $scope.orders[index].returned) != null ? ref : {
      "yes": "no"
    };
  };
});
