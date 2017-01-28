package com.travelbest.service;

import com.travelbest.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
  void save(User user);
  void delete(Long id);
  List<User> findAll();
  User findById(Long id);
  User findByEmail(String email);
}
