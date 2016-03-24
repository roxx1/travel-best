package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditOrdersController {

	@RequestMapping(value = "/edit/orders", method = RequestMethod.GET)
	public String getOrdersPage(Model model) {
		model.addAttribute("page", "edit-orders");
		return "edit-orders";
	}

	@RequestMapping(value = "/edit/orders", method = RequestMethod.POST)
	public String editOrders(Model model) {
		model.addAttribute("page", "edit-orders");
		return "edit-orders";
	}

}
