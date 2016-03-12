package com.travelbest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelbest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	void deleteUserById(long id);

	User findUserById(long id);

	User findUserByEmail(String email);

}
