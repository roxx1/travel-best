package com.travelbest.controller;

import com.travelbest.entity.Trip;
import com.travelbest.service.RouteService;
import com.travelbest.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TripsController {

	@Autowired
	private TripService tripService;

    @Autowired
    private RouteService routeService;

	@RequestMapping(value = "/trips", method = RequestMethod.GET)
	public String getAll(Model model) {

        List<Trip> trips = tripService.findAll();

		model.addAttribute("page", "trips");
		model.addAttribute("trips", trips);

		return "trips";
	}
	
	@RequestMapping(value = "/trips", method = RequestMethod.POST)
	public String buy(Model model) {
		model.addAttribute("page", "trips");
		return "trips";
	}

}
