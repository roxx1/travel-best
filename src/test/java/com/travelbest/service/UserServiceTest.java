package com.travelbest.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.travelbest.TravelApplication;
import com.travelbest.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelApplication.class)
@Transactional
public class UserServiceTest {

	@Autowired
	private UserServiceImpl userService;
	
	@Test
	@Ignore
	public void saveTest() {
		User jack = new User("Jack", "Jackson", "Bla-bla", "jack.jackson@gmail.com", "123");
		userService.save(jack);
		User jackFromDatabase = userService.findById(1L);
		assertTrue(jack.equals(jackFromDatabase));
	}

	@Test
	@Ignore
	public void findByEmailTest() {
		User jack = new User("Jack", "Jackson", "Bla-bla", "jack.jackson@gmail.com", "123");
		userService.save(jack);
		User jackFromDatabase = userService.findByEmail("jack.jackson@gmail.com");
		assertTrue(jack.equals(jackFromDatabase));
	}

	@Test
	@Ignore
	public void deleteTest() {
		User jack = new User("Jack", "Jackson", "Bla-bla", "jack.jackson@gmail.com", "123");
		userService.save(jack);
		userService.delete(jack.getId());
		assertNull(userService.findById(jack.getId()));
	}
	
	@Test
	@Ignore
	public void findAll() {
		userService.save(new User());
		userService.save(new User());
		userService.save(new User());
		
		assertEquals(userService.findAll().size(), 3);
	}

}
