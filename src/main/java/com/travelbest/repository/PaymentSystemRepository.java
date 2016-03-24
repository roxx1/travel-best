package com.travelbest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelbest.entity.PaymentSystem;

@Repository
public interface PaymentSystemRepository extends JpaRepository<PaymentSystem, Long> {

}
