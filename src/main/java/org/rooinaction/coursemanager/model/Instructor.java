package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Instructor extends Person {

    /**
     */
    @NotNull
    @Size(min = 9, max = 9)
    private String taxNumber;

    /**
     */
    private Boolean active;
}
