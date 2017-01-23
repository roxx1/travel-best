package com.travelbest.repository;

import com.travelbest.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface GuideRepository extends JpaRepository<Guide, Long> {
}
