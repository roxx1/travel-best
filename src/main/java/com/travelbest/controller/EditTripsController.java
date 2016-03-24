package com.travelbest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EditTripsController {

	@RequestMapping(value = "/edit/trips", method = RequestMethod.GET)
	public String getTripsPage(Model model) {
		model.addAttribute("page", "edit-trips");
		return "edit-trips";
	}

	@RequestMapping(value = "/edit/trips", method = RequestMethod.POST)
	public String editTripsPage(Model model) {
		model.addAttribute("page", "edit-trips");
		return "edit-trips";
	}

}
