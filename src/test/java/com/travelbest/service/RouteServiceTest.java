package com.travelbest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.travelbest.TravelApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelApplication.class)
@Transactional
public class RouteServiceTest {

	@Test
	public void saveTest() {
		
	}

}
