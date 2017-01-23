package com.travelbest.repository;

import com.travelbest.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface RouteRepository extends JpaRepository<Route, Long> {
}
