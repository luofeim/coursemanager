package org.rooinaction.coursemanager.db;

import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rooinaction.coursemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;  

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class UserIntegrationTest {
	@Autowired
	UserRepository userRepository;

	User user = new User();

	public User setUser(String firstname, String lastname, String email, String role) {
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmailAddress(email);
		user.setRole(role);
		return(user);
	}

	@Before
	public void setup() {
		user = setUser("ray", "luo", "luofeim@kehwa.net", "ROLE_ADMIN");
		userRepository.saveAndFlush(user);
	}

	@Test
	public void testUser() {
		Assert.assertEquals(user, userRepository.findOne(user.getId()));
	}
	
	@Test
	public void testUserQueryDsl() {
		Assert.assertThat(user, equalTo(userRepository.customUniqueResultByName(user.getFirstname())));
		Assert.assertThat(user, equalTo(userRepository.customUniqueResultByFirtnameAndLastName(user.getFirstname(), user.getLastname())));
		Assert.assertThat(user, equalTo(userRepository.customUniqueResultByFirtnameAndLastNameBooleanBuilder(user.getFirstname(), user.getLastname())));
	}

	void printResults(List<User> users) {
		System.out.println("----------------------------------------");
		for (User myuser: users) {
			System.out.println(myuser.getFirstname() + " " + myuser.getLastname());
		}
	}
	
	@Test
	public void testUserQueryDslOrderBy() {
		user = setUser("susan", "lu", "susanlu@kehwa.net", "ROLE_ADMIN");
		userRepository.saveAndFlush(user);
		user = setUser("david", "luo", "davidluo@kehwa.net", "ROLE_ADMIN");
		userRepository.saveAndFlush(user);
		
		//Assert.assertThat(user, equalTo(userRepository.customUniqueResultByFirtnameAndLastName(user.getFirstname(), user.getLastname())));
		List<User> users = userRepository.customOrderdResults("ROLE_ADMIN", "asc");
		//printResults(users);
		Assert.assertThat(users.get(0).getFirstname(), is("david"));
		
		users = userRepository.customOrderdResults("ROLE_ADMIN", "desc");
		//printResults(users);
		Assert.assertThat(users.get(0).getFirstname(), is("susan"));
		
	}

}
