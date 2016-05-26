var Route;

module.exports = Route = (function() {
  function Route(id, destination, description, image) {
    this.id = id;
    this.destination = destination;
    this.description = description;
    this.image = "../imgs/trips/" + image;
  }

  return Route;

})();
