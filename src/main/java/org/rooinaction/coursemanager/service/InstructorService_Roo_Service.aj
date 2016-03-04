// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.service;

import java.util.List;
import org.rooinaction.coursemanager.model.Instructor;
import org.rooinaction.coursemanager.service.InstructorService;

privileged aspect InstructorService_Roo_Service {
    
    public abstract long InstructorService.countAllInstructors();    
    public abstract void InstructorService.deleteInstructor(Instructor instructor);    
    public abstract Instructor InstructorService.findInstructor(Long id);    
    public abstract List<Instructor> InstructorService.findAllInstructors();    
    public abstract List<Instructor> InstructorService.findInstructorEntries(int firstResult, int maxResults);    
    public abstract void InstructorService.saveInstructor(Instructor instructor);    
    public abstract Instructor InstructorService.updateInstructor(Instructor instructor);    
}
