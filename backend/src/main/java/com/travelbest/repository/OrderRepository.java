package com.travelbest.repository;

import com.travelbest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOneByUserId(@Param("user_id") Long userId);

    List<Order> findAllByUserId(@Param("user_id") Long userId);

    @Query("UPDATE orders SET rejected = true WHERE id = :orderId")
    void rejectOrder(Long orderId);

}
