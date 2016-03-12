$(document).ready ->
	$('.modal-trigger').leanModal();

	# Slider Configuration
	$('.slider').slider {
		full_width: true,
		indicators: false
	}

	$(window).scroll ->

		if $(@).scrollTop() > 400
			$("nav").addClass("static-nav")
		else
			$("nav").removeClass("static-nav")
