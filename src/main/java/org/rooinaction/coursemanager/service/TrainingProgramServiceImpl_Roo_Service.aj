// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.service;

import java.util.List;
import org.rooinaction.coursemanager.db.TrainingProgramRepository;
import org.rooinaction.coursemanager.model.TrainingProgram;
import org.rooinaction.coursemanager.service.TrainingProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TrainingProgramServiceImpl_Roo_Service {
    
    declare @type: TrainingProgramServiceImpl: @Service;
    
    declare @type: TrainingProgramServiceImpl: @Transactional;
    
    @Autowired
    TrainingProgramRepository TrainingProgramServiceImpl.trainingProgramRepository;
    
    public long TrainingProgramServiceImpl.countAllTrainingPrograms() {
        return trainingProgramRepository.count();
    }
    
    public void TrainingProgramServiceImpl.deleteTrainingProgram(TrainingProgram trainingProgram) {
        trainingProgramRepository.delete(trainingProgram);
    }
    
    public TrainingProgram TrainingProgramServiceImpl.findTrainingProgram(Long id) {
        return trainingProgramRepository.findOne(id);
    }
    
    public List<TrainingProgram> TrainingProgramServiceImpl.findAllTrainingPrograms() {
        return trainingProgramRepository.findAll();
    }
    
    public List<TrainingProgram> TrainingProgramServiceImpl.findTrainingProgramEntries(int firstResult, int maxResults) {
        return trainingProgramRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void TrainingProgramServiceImpl.saveTrainingProgram(TrainingProgram trainingProgram) {
        trainingProgramRepository.save(trainingProgram);
    }
    
    public TrainingProgram TrainingProgramServiceImpl.updateTrainingProgram(TrainingProgram trainingProgram) {
        return trainingProgramRepository.save(trainingProgram);
    }
    
}