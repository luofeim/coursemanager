package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.json.annotations.RooJson;

@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson
public class Registration {

    /**
     */
    @ManyToOne
    private Student student;

    /**
     */
    @ManyToOne
    private Course course;

    /**
     */
    private Boolean paymentMade;

    /**
     */
    private Boolean attended;
}
