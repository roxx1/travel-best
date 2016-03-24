package com.travelbest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbest.entity.PaymentSystem;
import com.travelbest.repository.PaymentSystemRepository;

@Service
public class PaymentSystemServiceImpl implements PaymentSystemService {

	@Autowired
	private PaymentSystemRepository paymentSystemRepository;

	@Override
	public void save(PaymentSystem paymentSystem) {
		paymentSystemRepository.save(paymentSystem);
	}

	@Override
	public void delete(long id) {
		paymentSystemRepository.delete(id);
	}

	@Override
	public List<PaymentSystem> findAll() {
		return paymentSystemRepository.findAll();
	}

	@Override
	public PaymentSystem findById(long id) {
		return paymentSystemRepository.findOne(id);
	}

}
