package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelbest.entity.Trip;

@RequestMapping(value = "/get/trip")
@Controller
public class TripRestController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Trip getTrip(@RequestParam(value = "name", required = false) String name) {
		return new Trip();
	}

}
