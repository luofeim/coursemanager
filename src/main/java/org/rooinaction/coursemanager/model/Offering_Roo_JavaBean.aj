// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import java.util.Date;
import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.Instructor;
import org.rooinaction.coursemanager.model.Offering;

privileged aspect Offering_Roo_JavaBean {
    
    public Date Offering.getOfferDate() {
        return this.offerDate;
    }
    
    public void Offering.setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }
    
    public String Offering.getLocationName() {
        return this.locationName;
    }
    
    public void Offering.setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    public Course Offering.getCourse() {
        return this.course;
    }
    
    public void Offering.setCourse(Course course) {
        this.course = course;
    }
    
    public Instructor Offering.getInstructor() {
        return this.instructor;
    }
    
    public void Offering.setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
}
