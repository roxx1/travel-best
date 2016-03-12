package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TripsController {
	
	@RequestMapping(value = "/trips", method = RequestMethod.GET)
	public String trips(Model model) {
		model.addAttribute("page", "trips");
		return "trips";
	}
	
	@RequestMapping(value = "/trips", method = RequestMethod.POST)
	public String buy(Model model) {
		model.addAttribute("page", "trips");
		return "trips";
	}
	

}
