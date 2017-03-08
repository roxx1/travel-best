package com.travelbest.repository;

import com.travelbest.entity.Trip;
import com.travelbest.entity.projection.TripInlineRouteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(excerptProjection = TripInlineRouteProjection.class)
public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findById(Long id);
}
