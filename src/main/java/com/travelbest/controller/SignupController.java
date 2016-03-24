package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model) {
		// TODO registration should be implemented here
		return new IndexController().index(model);
	}
	
}
