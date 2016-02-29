package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
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
