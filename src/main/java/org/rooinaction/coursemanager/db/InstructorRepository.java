package org.rooinaction.coursemanager.db;
import org.rooinaction.coursemanager.model.Instructor;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(domainType = Instructor.class)
public interface InstructorRepository {
}
