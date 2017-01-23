package com.travelbest.service;

import com.travelbest.entity.Trip;
import com.travelbest.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepository;
	
	@Override
	public Trip save(Trip trip) {
		return tripRepository.save(trip);
    }

	@Override
	public void delete(Long id) {
		tripRepository.delete(id);
	}

	@Override
	public Trip findById(Long id) {
		return tripRepository.findOne(id);
	}

	@Override
	public List<Trip> findAll() {
		return tripRepository.findAll();
	}

}
