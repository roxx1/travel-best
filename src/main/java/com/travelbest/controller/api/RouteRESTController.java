package com.travelbest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelbest.entity.Route;
import com.travelbest.service.RouteService;

@Controller
@RequestMapping(value = "/api")
public class RouteRESTController {
	
	@Autowired
	private RouteService routeService;
	
	@RequestMapping(value = "/routes", method = RequestMethod.GET)
	public @ResponseBody List<Route> getAllRoutes() {
		return routeService.findAll();
	}

}
