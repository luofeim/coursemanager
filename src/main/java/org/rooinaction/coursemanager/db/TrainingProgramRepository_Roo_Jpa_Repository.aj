// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.db;

import org.rooinaction.coursemanager.db.TrainingProgramRepository;
import org.rooinaction.coursemanager.model.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect TrainingProgramRepository_Roo_Jpa_Repository {
    
    declare parents: TrainingProgramRepository extends JpaRepository<TrainingProgram, Long>;
    
    declare parents: TrainingProgramRepository extends JpaSpecificationExecutor<TrainingProgram>;
    
    declare @type: TrainingProgramRepository: @Repository;
    
}
