package org.rooinaction.coursemanager.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.rooinaction.coursemanager.model.QUser;
import org.rooinaction.coursemanager.model.User;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;

public class UserRepositoryImpl implements UserRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	public User customUniqueResultByName(String name) {

		QUser qUser = QUser.user;
		JPAQuery query = new JPAQuery(em);	
		User user = query.from(qUser).where(qUser.firstname.eq(name)).uniqueResult(qUser);
		
		return(user);
		
	}

	public User customUniqueResultByFirtnameAndLastName(String firstname, String lastname) {
		QUser qUser = QUser.user;
		JPAQuery query = new JPAQuery(em);	
		User user = query.from(qUser).where(qUser.firstname.eq(firstname).and(qUser.lastname.eq(lastname))).uniqueResult(qUser);
		
		return(user);
	}
	
	public User customUniqueResultByFirtnameAndLastNameBooleanBuilder(String firstname, String lastname) {
		QUser qUser = QUser.user;
		JPAQuery query = new JPAQuery(em);	
		BooleanBuilder builder = new BooleanBuilder();
			// 也可以使用Express (如BoolExpress)
		builder.and(qUser.firstname.eq(firstname));
		builder.and(qUser.lastname.eq(lastname));
		User user = query.from(qUser).where(builder).uniqueResult(qUser);
		
		return(user);
	}

	public List<User> customOrderdResults(String role, String order) {
		QUser qUser = QUser.user;
		OrderSpecifier<String> firstnameOrder, lastnameOrder;
		if (order.equalsIgnoreCase("asc")) {
			firstnameOrder = qUser.firstname.asc();
			lastnameOrder = qUser.lastname.asc();
		}
		else {
			firstnameOrder = qUser.firstname.desc();
			lastnameOrder = qUser.lastname.desc();
		}
		
		JPAQuery query = new JPAQuery(em);	
		JPAQuery jpaquery = query.from(qUser).where(qUser.role.eq(role)).orderBy(firstnameOrder, lastnameOrder);
		List<User> users = jpaquery.list(qUser);
		
		return(users);
	}

}
