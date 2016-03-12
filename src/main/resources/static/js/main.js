$(document).ready(function() {
  $('.modal-trigger').leanModal();
  $('.slider').slider({
    full_width: true,
    indicators: false
  });
  return $(window).scroll(function() {
    if ($(this).scrollTop() > 400) {
      return $("nav").addClass("static-nav");
    } else {
      return $("nav").removeClass("static-nav");
    }
  });
});
