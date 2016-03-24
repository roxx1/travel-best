package com.travelbest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbest.entity.Order;
import com.travelbest.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void delete(long id) {
		orderRepository.delete(id);
	}

	@Override
	public Order findById(long id) {
		return orderRepository.findOne(id);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

}
