package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Student extends Person {

    /**
     */
    @NotNull
    @Size(min = 1, max = 30)
    private String emergencyContactName;

    /**
     */
    @NotNull
    @Size(min = 1, max = 80)
    private String emergencyContactInfo;

    /**
     */
    @Size(max = 30)
    private String dietaryRestrictions;
}
