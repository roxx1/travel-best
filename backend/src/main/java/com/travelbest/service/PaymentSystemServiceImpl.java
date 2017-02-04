package com.travelbest.service;

import com.travelbest.entity.PaymentSystem;
import com.travelbest.repository.PaymentSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentSystemServiceImpl implements PaymentSystemService {

  @Autowired
  private PaymentSystemRepository paymentSystemRepository;

  @Override
  public void save(PaymentSystem paymentSystem) {
    paymentSystemRepository.save(paymentSystem);
  }

  @Override
  public void delete(Long id) {
    paymentSystemRepository.delete(id);
  }

  @Override
  public List<PaymentSystem> findAll() {
    return paymentSystemRepository.findAll();
  }

  @Override
  public PaymentSystem findById(Long id) {
    return paymentSystemRepository.findOne(id);
  }

}
