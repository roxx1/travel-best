package com.travelbest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelbest.entity.Guide;

@Service
public interface GuideService {

	public void save(Guide guide);
	
	public void delete(long id);
	
	public Guide findById(long id);
	
	public List<Guide> findAll();
	
}
