// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.db;

import org.rooinaction.coursemanager.db.OfferingRepository;
import org.rooinaction.coursemanager.model.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect OfferingRepository_Roo_Jpa_Repository {
    
    declare parents: OfferingRepository extends JpaRepository<Offering, Long>;
    
    declare parents: OfferingRepository extends JpaSpecificationExecutor<Offering>;
    
    declare @type: OfferingRepository: @Repository;
    
}