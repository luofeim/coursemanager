package org.rooinaction.coursemanager.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rooinaction.coursemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class UserIntegrationTest {
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testUser() {
		User user = new User();
		user.setFirstname("ray");
		user.setLastname("luo");
		user.setEmailAddress("luofeim@kehwa.net");
		user.setRole("ROLE_ADMIN");
		userRepository.saveAndFlush(user);
		
		Assert.assertEquals(user, userRepository.findOne(user.getId()));
		
	}

}
