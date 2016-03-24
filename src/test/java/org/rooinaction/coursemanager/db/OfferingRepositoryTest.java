package org.rooinaction.coursemanager.db;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.OfferingDataOnDemand;
import org.rooinaction.coursemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class OfferingRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OfferingRepository offeringRepository;

	@Autowired
	OfferingDataOnDemand offeringDataOnDemand;

	void printResults(List<Offering> offerings) {
		System.out.println("----------------------------------------");
		for (Offering offering: offerings) {
			System.out.println(offering.getLocationName() + " " + offering.getUser());
		}
	}
	
	@Test
	public void testJoinAndSubQuery() {
		UserIntegrationTest userIntegrationTest = new UserIntegrationTest();
		User user;
		user = userIntegrationTest.setUser("susan", "lu", "susanlu@kehwa.net", "ROLE_ADMIN");
		userRepository.saveAndFlush(user);
		
		Offering offering1;
		offering1 = offeringDataOnDemand.getSpecificOffering(2);
		offering1.setUser(user);
		offeringRepository.saveAndFlush(offering1);
		
		Offering offering2 = offeringDataOnDemand.getSpecificOffering(4);
		offering2.setUser(user);
		offeringRepository.saveAndFlush(offering2);
		
		//List<Offering> offeringList = Arrays.asList(offering, offering1);

		Offering offering;
		user = userIntegrationTest.setUser("david", "luo", "davidluo@kehwa.net", "ROLE_USER");
		userRepository.saveAndFlush(user);
		offering = offeringDataOnDemand.getSpecificOffering(6);
		offering.setUser(user);
		offeringRepository.saveAndFlush(offering);
		
		List<Offering> offerings = offeringRepository.customFetchByJoin("ROLE_ADMIN");
//		printResults(offerings);
		Assert.assertThat(offerings, hasItems(offering1, offering2));
		
		offerings = offeringRepository.customFetchBySubQuery("ROLE_ADMIN");
//		printResults(offerings);
		Assert.assertThat(offerings, hasItems(offering1, offering2));
	}
}
