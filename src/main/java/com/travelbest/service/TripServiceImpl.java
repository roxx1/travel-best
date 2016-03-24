package com.travelbest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbest.entity.Trip;
import com.travelbest.repository.TripRepository;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepository;
	
	@Override
	public void save(Trip trip) {
		tripRepository.save(trip);
	}

	@Override
	public void delete(long id) {
		tripRepository.delete(id);
	}

	@Override
	public Trip findById(long id) {
		return tripRepository.findOne(id);
	}

	@Override
	public List<Trip> findAll() {
		return tripRepository.findAll();
	}

}
