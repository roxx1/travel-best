package com.travelbest.service;

import com.travelbest.entity.Guide;
import com.travelbest.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideRepository guideRepository;

	@Override
	public void save(Guide guide) {
		guideRepository.save(guide);
	}

	@Override
	public void delete(Long id) {
		guideRepository.delete(id);
	}

	@Override
	public Guide findById(Long id) {
		return guideRepository.findOne(id);
	}

	@Override
	public List<Guide> findAll() {
		return guideRepository.findAll();
	}

}
