var Guide, app;

app = angular.module('edit-guides', []);

Guide = (function() {
  function Guide(icon, name, surname, email, phone) {
    this.icon = icon;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.phone = phone;
  }

  return Guide;

})();

app.controller('editGuidesCtrl', function($scope) {
  return $scope.guides = [new Guide('../imgs/shopping-cart.svg', 'John', 'Smith', 'john.smith@gmail.com', '8372918273'), new Guide('../imgs/shopping-cart.svg', 'Sally', 'Melmon', 'sally.melmon@hotmail.com', '74839282772'), new Guide('../imgs/shopping-cart.svg', 'Derek', 'Anderson', 'derek.anderson@mail.ru', '83737262829')];
});
