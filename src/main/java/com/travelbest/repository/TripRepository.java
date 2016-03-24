package com.travelbest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelbest.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
