package com.travelbest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelbest.entity.Route;

@Repository
public interface RouteRepository extends  JpaRepository<Route, Long> {

}
