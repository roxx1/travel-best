package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("page", "home");
		return "index";
	}

    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("page", "trips");
        return "trips";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Model model) {
        model.addAttribute("page", "orders");
        return "orders";
    }

    @RequestMapping(value = "/edit/trips", method = RequestMethod.GET)
    public String getTripsPage(Model model) {
        model.addAttribute("page", "edit-trips");
        return "edit-trips";
    }

    @RequestMapping(value = "/edit/routes", method = RequestMethod.GET)
    public String getRoutes(Model model) {
        model.addAttribute("page", "edit-routes");
        return "edit-routes";
    }

    @RequestMapping(value = "/edit/orders", method = RequestMethod.GET)
    public String getOrdersPage(Model model) {
        model.addAttribute("page", "edit-orders");
        return "edit-orders";
    }

    @RequestMapping(value="/edit/finance", method=RequestMethod.GET)
    public String getFinanceInfo(Model model) {
        model.addAttribute("page", "edit-finance");
        return "edit-finance";
    }

}