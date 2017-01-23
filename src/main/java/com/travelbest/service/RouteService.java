package com.travelbest.service;

import com.travelbest.entity.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {
    Route save(Route route);
    void delete(Long id);
    List<Route> findAll();
    Route findById(Long id);
}
