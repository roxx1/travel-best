package com.travelbest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelbest.entity.User;

@Service
public interface UserService {
	void save(User user);

	void delete(long id);

	List<User> findAll();

	User findById(long id);

	User findByEmail(String email);
}
