package com.travelbest.service;

import com.travelbest.entity.User;
import com.travelbest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

  @Override
  public void save(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
    userRepository.save(user);
  }

  @Override
  public void delete(Long id) {
    userRepository.delete(id);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(Long id) {
    return userRepository.findOne(id);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findUserByEmail(email);
  }

}
