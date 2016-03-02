package org.rooinaction.coursemanager.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.json.annotations.RooJson;

@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson
public class Offering {

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MM/DD/YYYY")
    private Date offerDate;

    /**
     */
    @NotNull
    @Size(min = 1, max = 80)
    private String locationName;

    /**
     */
    @ManyToOne
    private Course course;

    /**
     */
    @ManyToOne
    private Instructor instructor;
}
