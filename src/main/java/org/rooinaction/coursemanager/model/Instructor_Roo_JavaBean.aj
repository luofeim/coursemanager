// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import org.rooinaction.coursemanager.model.Instructor;

privileged aspect Instructor_Roo_JavaBean {
    
    public String Instructor.getTaxNumber() {
        return this.taxNumber;
    }
    
    public void Instructor.setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
    
    public Boolean Instructor.getActive() {
        return this.active;
    }
    
    public void Instructor.setActive(Boolean active) {
        this.active = active;
    }
    
}