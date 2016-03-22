package org.rooinaction.coursemanager.db;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.rooinaction.coursemanager.model.Offering;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
	public static Specification<Offering> searchByUserRole(final String role) {
		return new Specification<Offering>() {
			@Override
			public Predicate toPredicate(Root<Offering> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				Predicate isUserRoleSame = cb.equal(root.<String> get("user.role"), role);
				return isUserRoleSame;
			}
		};
	}

}
