// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.service;

import java.util.List;
import org.rooinaction.coursemanager.model.TrainingProgram;
import org.rooinaction.coursemanager.service.TrainingProgramService;

privileged aspect TrainingProgramService_Roo_Service {
    
    public abstract long TrainingProgramService.countAllTrainingPrograms();    
    public abstract void TrainingProgramService.deleteTrainingProgram(TrainingProgram trainingProgram);    
    public abstract TrainingProgram TrainingProgramService.findTrainingProgram(Long id);    
    public abstract List<TrainingProgram> TrainingProgramService.findAllTrainingPrograms();    
    public abstract List<TrainingProgram> TrainingProgramService.findTrainingProgramEntries(int firstResult, int maxResults);    
    public abstract void TrainingProgramService.saveTrainingProgram(TrainingProgram trainingProgram);    
    public abstract TrainingProgram TrainingProgramService.updateTrainingProgram(TrainingProgram trainingProgram);    
}