package org.rooinaction.coursemanager.db;
import org.rooinaction.coursemanager.model.Student;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(domainType = Student.class)
public interface StudentRepository {
}
