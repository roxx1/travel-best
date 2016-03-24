package com.travelbest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbest.entity.User;
import com.travelbest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserRepository userDAO) {
		setUserDAO(userDAO);
	}

	public void setUserDAO(UserRepository userDAO) {
		this.userRepository = userDAO;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}
