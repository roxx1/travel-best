package com.travelbest.entity.projection;

import com.travelbest.entity.Order;
import com.travelbest.entity.Trip;
import com.travelbest.entity.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="inline-user-and-trip", types = {Order.class})
public interface OrderInlineUserAndTrip {
    Long getId();
    Long getUser();
    void setUser(User user);
    Long getTrip();
    void setTrip(Trip trip);
    Date getPayDate();
    void setPayDate(Date payDate);
}
