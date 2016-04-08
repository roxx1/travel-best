package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditRoutesController {

	@RequestMapping(value = "/edit/routes", method = RequestMethod.GET)
	public String getRoutes(Model model) {
		model.addAttribute("page", "edit-routes");
		return "edit-routes";
	}
	
	@RequestMapping(value = "/edit/routes", method = RequestMethod.POST)
	public String editRoutes(Model model) {
		model.addAttribute("page", "edit-routes");
		return "edit-routes";
	}
	
}
