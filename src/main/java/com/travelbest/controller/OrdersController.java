package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrdersController {

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orders(Model model) {
		model.addAttribute("page", "orders");
		return "orders";
	}

}
