package com.travelbest.repository;

import com.travelbest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findByUsername(String username);
}
