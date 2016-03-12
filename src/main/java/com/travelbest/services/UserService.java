package com.travelbest.services;

import java.util.List;

import com.travelbest.entity.User;

public interface UserService {
	void addUser(User user);

	void deleteUser(long id);

	List<User> listAllUsers();

	User findUserById(long id);
	
	User findUserByEmail(String email);
}
