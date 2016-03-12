package com.travelbest.services;

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
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteUserById(id);
	}

	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(long id) {
		return userRepository.findUserById(id);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}
