package com.travelbest.service;

import com.travelbest.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    Trip save(Trip trip);
    void delete(Long id);
    Trip findById(Long id);
    List<Trip> findAll();
}
