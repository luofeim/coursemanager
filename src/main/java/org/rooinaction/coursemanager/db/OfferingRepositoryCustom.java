package org.rooinaction.coursemanager.db;

import java.util.List;

import org.rooinaction.coursemanager.model.Offering;

public interface OfferingRepositoryCustom {
	
	public List<Offering> customFetchByJoin(String role);

	public List<Offering> customFetchBySubQuery(String role);

}
