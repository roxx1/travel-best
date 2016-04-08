app = angular.module('edit-guides', [])

class Guide
	constructor: (@icon, @name, @surname, @email, @phone) ->

app.controller 'editGuidesCtrl', ($scope) ->
	$scope.guides = [
		new Guide('../imgs/shopping-cart.svg', 'John', 'Smith', 'john.smith@gmail.com', '8372918273')
		new Guide('../imgs/shopping-cart.svg', 'Sally', 'Melmon', 'sally.melmon@hotmail.com', '74839282772')
		new Guide('../imgs/shopping-cart.svg', 'Derek', 'Anderson', 'derek.anderson@mail.ru', '83737262829')
	]