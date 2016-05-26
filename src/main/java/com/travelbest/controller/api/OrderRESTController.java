package com.travelbest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelbest.entity.Order;
import com.travelbest.service.OrderService;

@Controller
@RequestMapping(value = "/api")
public class OrderRESTController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public @ResponseBody List<Order> getAllOrders() {
		return orderService.findAll();
	}

}
