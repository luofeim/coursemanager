package org.rooinaction.coursemanager.service;
import org.rooinaction.coursemanager.model.Course;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import org.springframework.security.access.prepost.PreAuthorize;

@RooService(domainTypes = { org.rooinaction.coursemanager.model.Course.class })
public interface CourseService {
/*	@Secured("ROLE_ADMIN")
*/  
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public abstract void saveCourse(Course course);    
}
