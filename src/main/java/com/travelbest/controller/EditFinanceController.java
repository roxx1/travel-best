package com.travelbest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditFinanceController {

	@RequestMapping(value="/edit/finance", method=RequestMethod.GET)
	public String getFinanceInfo(Model model) {
		model.addAttribute("page", "edit-finance");
		return "edit-finance";
	}
	
	@RequestMapping(value="/edit/finance", method=RequestMethod.POST)
	public String editFinanceInfo(Model model) {
		model.addAttribute("page", "edit-finance");
		return "edit-finance";
	}
}
