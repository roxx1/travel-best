package com.travelbest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbest.entity.Route;
import com.travelbest.repository.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Override
	public void save(Route route) {
		routeRepository.save(route);
	}

	@Override
	public void delete(long id) {
		routeRepository.delete(id);
	}

	@Override
	public List<Route> findAll() {
		return routeRepository.findAll();
	}

	@Override
	public Route findById(long id) {
		return routeRepository.findOne(id);
	}

}
