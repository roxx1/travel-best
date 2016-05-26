package com.travelbest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelbest.entity.Trip;
import com.travelbest.service.TripService;

@Controller
@RequestMapping(value = "/api")
public class TripRESTController {
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping(value = "/trips", method = RequestMethod.GET)
	public @ResponseBody List<Trip> getAllTrips() {
		return tripService.findAll();
	}

}
