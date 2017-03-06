package com.travelbest.repository;

import com.travelbest.entity.Route;
import com.travelbest.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Projection(name="route", types = {Trip.class})
interface TripInlineRouteProjection {
    Long getId();
    Double getPrice();
    Date getExpirationDate();
    Date getTripStartDate();
    Date getTripEndDate();
    Integer getAmountOfTourists();
    Integer getMinAmountOfTourists();
    Integer getMaxAmountOfTourists();
    Double getinsuranceSum();
    Route getRoute();
}

@Repository
@RepositoryRestResource(excerptProjection = TripInlineRouteProjection.class)
public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findById(Long id);
}
