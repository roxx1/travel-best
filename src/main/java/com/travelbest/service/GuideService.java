package com.travelbest.service;

import com.travelbest.entity.Guide;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuideService {
    void save(Guide guide);
    void delete(Long id);
    Guide findById(Long id);
    List<Guide> findAll();
}
