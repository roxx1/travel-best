package com.travelbest.service;

import com.travelbest.entity.PaymentSystem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentSystemService {
  void save(PaymentSystem paymentSystem);
  void delete(Long id);
  List<PaymentSystem> findAll();
  PaymentSystem findById(Long id);
}
