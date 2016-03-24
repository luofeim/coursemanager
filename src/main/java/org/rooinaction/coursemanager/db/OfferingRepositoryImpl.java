package org.rooinaction.coursemanager.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.QOffering;
import org.rooinaction.coursemanager.model.QUser;
import org.rooinaction.coursemanager.model.User;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.query.SimpleSubQuery;

public class OfferingRepositoryImpl implements OfferingRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public List<Offering> customFetchByJoin(String role) {
		QOffering qOffering = QOffering.offering;
		QUser quser = QUser.user;
		JPAQuery query = new JPAQuery(em);	
		List<Offering>  offerings = query.from(qOffering).leftJoin(qOffering.user, quser)
				.where(quser.role.eq(role)).list(qOffering);
		return(offerings);
	}

	public List<Offering> customFetchBySubQuery(String role) {
		QOffering qOffering = QOffering.offering;
		QUser quser = QUser.user;
		JPAQuery query = new JPAQuery(em);	
		SimpleSubQuery<User> subquery = new JPASubQuery().from(quser).where(quser.role.eq(role)).unique(quser);
		List<Offering>  offerings = query.from(qOffering).where(qOffering.user.eq(subquery)).list(qOffering);
		return(offerings);
	}
}
