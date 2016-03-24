package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditGuidesController {

	@RequestMapping(value = "/edit/guides", method = RequestMethod.GET)
	public String getGuidesPage(Model model) {
		model.addAttribute("page", "edit-guides");
		return "edit-guides";
	}

	@RequestMapping(value = "/edit/guides", method = RequestMethod.POST)
	public String editGuides(Model model) {
		model.addAttribute("page", "edit-guides");
		return "edit-guides";
	}

}
