module.exports = class Route
	constructor: (@id, @destination, @description, image) ->
		@image = "../imgs/trips/" + image