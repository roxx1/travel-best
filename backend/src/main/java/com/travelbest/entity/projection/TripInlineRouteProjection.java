package com.travelbest.entity.projection;

import com.travelbest.entity.Route;
import com.travelbest.entity.Trip;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="route", types = {Trip.class})
public interface TripInlineRouteProjection {
    Long getId();
    Double getPrice();
    Date getExpirationDate();
    Date getTripStartDate();
    Date getTripEndDate();
    Integer getAmountOfTourists();
    Integer getMinAmountOfTourists();
    Integer getMaxAmountOfTourists();
    Double getInsuranceSum();
    Route getRoute();
}

