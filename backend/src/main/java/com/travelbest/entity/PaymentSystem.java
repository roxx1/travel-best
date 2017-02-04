package com.travelbest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "payment_systems")
@Data
@NoArgsConstructor
public class PaymentSystem {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    public PaymentSystem(String name) {
        this.setName(name);
    }
}
