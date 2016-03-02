package org.rooinaction.coursemanager.model;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Course {

    /**
     */
    @Column(name = "course_name")
    @Size(min = 1, max = 60)
    private String name;

    /**
     */
    @NotNull
    @Size(max = 1000)
    private String description;

    /**
     */
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("99999.99")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal listPrice;

    /**
     */
    @NotNull
    @Column(name = "max_capacity")
    @Min(1L)
    @Max(9999L)
    private Integer maximumCapacity;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date runDate;

    /**
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;

    /**
     */
    @ManyToOne
    private TrainingProgram trainingProgram;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private Set<Tag> tags = new HashSet<Tag>();
    
    /**
     * trigger validation failure when returning false: if name == "ray " && listPrice == 99.0
     * error message:
     * 	propertyPath = multiFieldsValid
     * 	message = ... or message_template_name (javax.validation.constraints.NotNull.message)
     */
    @AssertTrue(message =
    		"validation: [name] == ray && [listPrice] == 99.0")
    public boolean isMultiFieldsValid() {
    	return(!(name.equalsIgnoreCase("ray") && listPrice.doubleValue() == 99.0));
    }
}
