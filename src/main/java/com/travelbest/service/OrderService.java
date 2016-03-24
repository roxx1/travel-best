package com.travelbest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelbest.entity.Order;

@Service
public interface OrderService {

	public void save(Order order);

	public void delete(long id);

	public Order findById(long id);

	public List<Order> findAll();

}
