package com.travelbest.service;

import com.travelbest.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
	void save(Order order);
	void delete(Long id);
	Order findById(Long id);
	List<Order> findAll();
}
