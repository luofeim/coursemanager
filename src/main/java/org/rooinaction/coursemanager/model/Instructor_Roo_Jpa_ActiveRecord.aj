// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import java.util.List;
import org.rooinaction.coursemanager.model.Instructor;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Instructor_Roo_Jpa_ActiveRecord {
    
    public static final List<String> Instructor.fieldNames4OrderClauseFilter = java.util.Arrays.asList("taxNumber", "active");
    
    public static long Instructor.countInstructors() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Instructor o", Long.class).getSingleResult();
    }
    
    public static List<Instructor> Instructor.findAllInstructors() {
        return entityManager().createQuery("SELECT o FROM Instructor o", Instructor.class).getResultList();
    }
    
    public static List<Instructor> Instructor.findAllInstructors(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Instructor o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Instructor.class).getResultList();
    }
    
    public static Instructor Instructor.findInstructor(Long id) {
        if (id == null) return null;
        return entityManager().find(Instructor.class, id);
    }
    
    public static List<Instructor> Instructor.findInstructorEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Instructor o", Instructor.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Instructor> Instructor.findInstructorEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Instructor o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Instructor.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public Instructor Instructor.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Instructor merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
