// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.Registration;
import org.rooinaction.coursemanager.model.Student;

privileged aspect Registration_Roo_JavaBean {
    
    public Student Registration.getStudent() {
        return this.student;
    }
    
    public void Registration.setStudent(Student student) {
        this.student = student;
    }
    
    public Course Registration.getCourse() {
        return this.course;
    }
    
    public void Registration.setCourse(Course course) {
        this.course = course;
    }
    
    public Boolean Registration.getPaymentMade() {
        return this.paymentMade;
    }
    
    public void Registration.setPaymentMade(Boolean paymentMade) {
        this.paymentMade = paymentMade;
    }
    
    public Boolean Registration.getAttended() {
        return this.attended;
    }
    
    public void Registration.setAttended(Boolean attended) {
        this.attended = attended;
    }
    
}