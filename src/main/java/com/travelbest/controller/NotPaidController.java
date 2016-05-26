package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NotPaidController {

	@RequestMapping(value = "/not-paid-user", method = RequestMethod.GET)
	public String notPaidUser() {
		return "not-paid-user";
	}
	
	@RequestMapping(value = "/not-paid-admin", method = RequestMethod.GET)
	public String notPaidAdmin() {
		return "not-paid-admin";
	}
}
