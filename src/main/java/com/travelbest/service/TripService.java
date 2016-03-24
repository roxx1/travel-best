package com.travelbest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelbest.entity.Trip;

@Service
public interface TripService {

	public void save(Trip trip);

	public void delete(long id);

	public Trip findById(long id);

	public List<Trip> findAll();

}
