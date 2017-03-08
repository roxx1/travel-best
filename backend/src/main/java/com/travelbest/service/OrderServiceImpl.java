package com.travelbest.service;

import com.travelbest.entity.Order;
import com.travelbest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public void save(Order order) {
    orderRepository.save(order);
  }

  @Override
  public void delete(Long id) {
    orderRepository.delete(id);
  }

  @Override
  public Order findOne(Long id) {
      return orderRepository.findOne(id);
  }

  @Override
  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findOneByUserId(Long userId) {
      return orderRepository.findOneByUserId(userId);
  }

  @Override
  public List<Order> findAllByUserId(Long userId) {
      return orderRepository.findAllByUserId(userId);
  }

  @Override
  public void rejectOrder(Long orderId) {
      orderRepository.rejectOrder(orderId);
  }

}
