package com.travelbest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbest.entity.Guide;
import com.travelbest.repository.GuideRepository;

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideRepository guideRepository;

	@Override
	public void save(Guide guide) {
		guideRepository.save(guide);
	}

	@Override
	public void delete(long id) {
		guideRepository.delete(id);
	}

	@Override
	public Guide findById(long id) {
		return guideRepository.findOne(id);
	}

	@Override
	public List<Guide> findAll() {
		return guideRepository.findAll();
	}

}
