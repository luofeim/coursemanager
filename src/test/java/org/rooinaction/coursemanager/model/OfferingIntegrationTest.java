package org.rooinaction.coursemanager.model;

import static java.util.Collections.singleton;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.rooinaction.coursemanager.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.test.annotations.RooIntegrationTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.hamcrest.CoreMatchers.*;  
//import static org.junit.matchers.JUnitMatchers.*;

@RooIntegrationTest(entity = Offering.class)
public class OfferingIntegrationTest {

	@Test
	public void testMarkerMethod() {
	}

	@Autowired
	UserRepository userRepository;

	public Offering prepareOffering(String firstname, String lastname, String emailAddress, String role,
			int offeringIndex) {
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmailAddress(emailAddress);
		user.setRole(role);
		userRepository.saveAndFlush(user);

		Offering offering = dod.getSpecificOffering(offeringIndex);
		offering.setUser(user);
		offeringRepository.save(offering);

		return (offering);
	}

	void printOfferingForDebug(List<Offering> offerings){
		System.out.println("------------------ offerings ---------------------");
		for (Offering offering : offerings) {
			System.out.println(offering.getLocationName());
			User user = offering.getUser();
			String role = (user == null) ? "null" : user.getRole();
			System.out.println("......" + role);
		}
	}
	
	@Test
	public void testFindAllByUserRole() {
		prepareOffering("ray", "luo", "luofeim@kehwa.net", "ROLE_ADMIN", 3);
		prepareOffering("susan", "lu", "susanlu@kehwa.net", "ROLE_USER", 5);
		prepareOffering("david", "luo", "luokaiy@kehwa.net", "ROLE_USER", 7);

//		List<Offering> offerings = offeringRepository.findAll(UserSpecification.searchByUserRole("ROLE_USER"));
//		List<Offering> offerings = offeringRepository.findByUser_Role("ROLE_USER");
		List<Offering> offerings = offeringRepository.fetchByUser_Role("ROLE_USER");
		printOfferingForDebug(offerings);
	}

	@Test
	public void testFindAllByUserRoleSecurity() {
		Offering offeringData;
		offeringData = prepareOffering("ray", "luo", "luofeim@kehwa.net", "ROLE_ADMIN", 3);
		UsernamePasswordAuthenticationToken rayAuth = new UsernamePasswordAuthenticationToken(offeringData.getUser(), "x", 	
			singleton(new SimpleGrantedAuthority("admin")));
		offeringData = prepareOffering("susan", "lu", "susanlu@kehwa.net", "ROLE_USER", 5);
		UsernamePasswordAuthenticationToken susanAuth = new UsernamePasswordAuthenticationToken(offeringData.getUser(), "x", 	
				singleton(new SimpleGrantedAuthority("user")));
		offeringData = prepareOffering("david", "luo", "luokaiy@kehwa.net", "ROLE_USER", 7);
		UsernamePasswordAuthenticationToken davidAuth = new UsernamePasswordAuthenticationToken(offeringData.getUser(), "x", 	
				singleton(new SimpleGrantedAuthority("user")));

		SecurityContextHolder.getContext().setAuthentication(davidAuth);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().contains(new SimpleGrantedAuthority("admin")) ? "ROLE_ADMIN" : "ROLE_USER";

		List<Offering> offerings = offeringRepository.fetchByUser_Role(role);
//		printOfferingForDebug(offerings);
		Assert.assertThat(offerings.size(), is(2));
		
		
		SecurityContextHolder.getContext().setAuthentication(rayAuth);
		auth = SecurityContextHolder.getContext().getAuthentication();
		role = auth.getAuthorities().contains(new SimpleGrantedAuthority("admin")) ? "ROLE_ADMIN" : "ROLE_USER";
		offerings = offeringRepository.fetchByUser_Role(role);
//		printOfferingForDebug(offerings);
		Assert.assertThat(offerings.size(), is(1));
	}
	
	@Test
	public void testSecuritySqlFilter() {
		Offering offeringData;
		offeringData = prepareOffering("ray", "luo", "luofeim@kehwa.net", "ROLE_ADMIN", 3);
		User user = offeringData.getUser();
		Offering newOffering = dod.getSpecificOffering(5);
		newOffering.setUser(user);
		offeringRepository.saveAndFlush(newOffering);
		UsernamePasswordAuthenticationToken rayAuth = new UsernamePasswordAuthenticationToken(user, "x", 	
			singleton(new SimpleGrantedAuthority("admin")));

		offeringData = prepareOffering("david", "luo", "davidluo@kehwa.net", "ROLE_USER", 7);
		user = offeringData.getUser();
		newOffering = dod.getSpecificOffering(9);
		newOffering.setUser(user);
		offeringRepository.saveAndFlush(newOffering);
		UsernamePasswordAuthenticationToken davidAuth = new UsernamePasswordAuthenticationToken(user, "x",
				singleton(new SimpleGrantedAuthority("user")));

		String locationName = "locationName".substring(0, 1);
		List<Offering> offerings;

		//测试jpa native sql
		//测试未登录
		SecurityContextHolder.getContext().setAuthentication(null);
		offerings = offeringRepository.findOfferingBySecurityRole(locationName);
		printOfferingForDebug(offerings);
//		Assert.assertThat(offerings.size(), is(2));

		//测试ROLE_USER
		SecurityContextHolder.getContext().setAuthentication(davidAuth);
		offerings = offeringRepository.findOfferingBySecurityRole(locationName);
		printOfferingForDebug(offerings);
//		Assert.assertThat(offerings.size(), is(2));
		
		//测试ROLE_ADMIN
		SecurityContextHolder.getContext().setAuthentication(rayAuth);
		offerings = offeringRepository.findOfferingBySecurityRole(locationName);
		printOfferingForDebug(offerings);
//		Assert.assertThat(offerings.size(), is(2));
		
		//测试jpa
		//测试未登录
		SecurityContextHolder.getContext().setAuthentication(null);
		offerings = offeringRepository.findOfferingBySecurityRole2(locationName);
		printOfferingForDebug(offerings);
//		Assert.assertThat(offerings.size(), is(2));

		//测试ROLE_USER
		SecurityContextHolder.getContext().setAuthentication(davidAuth);
		offerings = offeringRepository.findOfferingBySecurityRole2(locationName);
		printOfferingForDebug(offerings);
//		Assert.assertThat(offerings.size(), is(2));
		
		//测试ROLE_ADMIN
		SecurityContextHolder.getContext().setAuthentication(rayAuth);
		offerings = offeringRepository.findOfferingBySecurityRole2(locationName);
		printOfferingForDebug(offerings);
//		Assert.assertThat(offerings.size(), is(2));
	}
}
