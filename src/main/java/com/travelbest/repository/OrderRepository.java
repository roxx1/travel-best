package com.travelbest.repository;

import com.travelbest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {
}
