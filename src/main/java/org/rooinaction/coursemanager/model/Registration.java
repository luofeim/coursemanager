package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity
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

    /**
     */
    @ManyToOne
    private Offering offering;
}
