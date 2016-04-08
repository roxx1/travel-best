package com.travelbest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelbest.entity.User;
import com.travelbest.service.UserService;

@Controller
@RequestMapping(value = "/api")
public class UserRESTController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllOrders() {
		return userService.findAll();
	}

}
