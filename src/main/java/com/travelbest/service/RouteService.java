package com.travelbest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelbest.entity.Route;

@Service
public interface RouteService {

	void save(Route route);

	void delete(long id);

	List<Route> findAll();

	Route findById(long id);

}
