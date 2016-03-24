package com.travelbest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelbest.entity.PaymentSystem;

@Service
public interface PaymentSystemService {

	void save(PaymentSystem paymentSystem);

	void delete(long id);

	List<PaymentSystem> findAll();

	PaymentSystem findById(long id);
	
}
