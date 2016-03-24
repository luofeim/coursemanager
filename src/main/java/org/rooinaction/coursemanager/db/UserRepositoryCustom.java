package org.rooinaction.coursemanager.db;

import java.util.List;

import org.rooinaction.coursemanager.model.User;

public interface UserRepositoryCustom {
	
	public User customUniqueResultByName(String name);
	
	public User customUniqueResultByFirtnameAndLastName(String firstname, String lastname);

	public User customUniqueResultByFirtnameAndLastNameBooleanBuilder(String firstname, String lastname);
	
	public List<User> customOrderdResults(String role, String order);
}
