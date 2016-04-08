package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserDetailsController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUserDetails(Model model) {
		model.addAttribute("page", "user-details");
		return "user-details";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String editUserDetails(Model model) {
		model.addAttribute("page", "user-details");
		return "user-details";
	}


}