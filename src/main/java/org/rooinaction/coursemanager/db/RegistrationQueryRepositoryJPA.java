package org.rooinaction.coursemanager.db;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.rooinaction.coursemanager.model.Registration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegistrationQueryRepositoryJPA implements RegistrationQueryRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public TypedQuery<Registration> findRegistrationsByStudent(Long studentId, Date startDate, Date endDate) {
		TypedQuery<Registration> q = em.createQuery(
				"select distinct r from Registration as r " + "where r.student.id = :studentId "
						+ "and r.offering.offerDate between :start and :end",
				Registration.class);
		q.setParameter("studentId", studentId);
		q.setParameter("start", startDate);
		q.setParameter("end", endDate);
		return q;
	}

}
