package com.travelbest.repository;

import com.travelbest.entity.PaymentSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface PaymentSystemRepository extends JpaRepository<PaymentSystem, Long> {
}
