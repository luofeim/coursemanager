package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Course {

    /**
     */
    @Column(name = "course_name")
    @Size(min = 1, max = 60)
    private String name;
}
