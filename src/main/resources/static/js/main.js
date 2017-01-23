$(document).ready(function() {
  $('.modal-trigger').leanModal();

  $('.slider').slider({
    full_width: true,
    indicators: false
  });
  $(window).scroll(function() {
    if ($(this).scrollTop() > 400) {
      $("nav").addClass("static-nav");
    } else {
      $("nav").removeClass("static-nav");
    }
  });
});
