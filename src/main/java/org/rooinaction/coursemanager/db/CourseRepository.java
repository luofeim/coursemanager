package org.rooinaction.coursemanager.db;
import org.rooinaction.coursemanager.model.Course;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(domainType = Course.class)
public interface CourseRepository {
}
