package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.json.annotations.RooJson;

@RooJavaBean
@RooToString
@RooJpaEntity(inheritanceType = "TABLE_PER_CLASS")
@RooJson
public abstract class Person {

    /**
     */
    @Size(min = 1, max = 30)
    private String firstName;

    /**
     */
    @Size(min = 1, max = 30)
    private String middleNameOrInitial;

    /**
     */
    @NotNull
    @Size(min = 1, max = 60)
    private String addressLine1;

    /**
     */
    @Size(min = 0, max = 60)
    private String addressLine2;

    /**
     */
    @Size(min = 0, max = 40)
    private String city;

    /**
     */
    @Size(min = 2, max = 2)
    private String stateCode;

    /**
     */
    @NotNull
    @Size(min = 1, max = 10)
    private String postalCode;

    /**
     */
    @NotNull
    @Size(min = 1, max = 80)
    private String emailAddress;
}
