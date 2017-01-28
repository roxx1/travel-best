package com.travelbest.service;

import com.travelbest.entity.Route;
import com.travelbest.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

  @Autowired
  private RouteRepository routeRepository;

  @Override
  public Route save(Route route) {
    return routeRepository.save(route);
    }

  @Override
  public void delete(Long id) {
    routeRepository.delete(id);
  }

  @Override
  public List<Route> findAll() {
    return routeRepository.findAll();
  }

  @Override
  public Route findById(Long id) {
    return routeRepository.findOne(id);
  }

}
