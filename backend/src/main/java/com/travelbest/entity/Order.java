package com.travelbest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_system_id")
    private PaymentSystem paymentSystem;

    @Column(name = "pay_date")
    private Date payDate;

    private Boolean rejected;
    private Boolean returned;

    public Order(Trip trip, User user, PaymentSystem paymentSystem, Date payDate) {
        this.setTrip(trip);
        this.setUser(user);
        this.setPaymentSystem(paymentSystem);
        this.setPayDate(payDate);
    }
}
