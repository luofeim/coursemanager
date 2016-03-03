package org.rooinaction.coursemanager.db;

import java.util.Date;

import javax.persistence.TypedQuery;

import org.rooinaction.coursemanager.model.Registration;

public interface RegistrationQueryRepository {
	TypedQuery<Registration> findRegistrationsByStudent(Long studentId, Date startDate, Date endDate);
}
