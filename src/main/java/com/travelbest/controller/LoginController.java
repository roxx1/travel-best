package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model) {
		// TODO authorization should be implemented here
		return new IndexController().index(model);
	}
	
}
