// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.CourseTypeEnum;

privileged aspect Course_Roo_Finder {
    
    public static Long Course.countFindCoursesByCourseTypeAndRunDateBetween(CourseTypeEnum courseType, Date minRunDate, Date maxRunDate) {
        if (courseType == null) throw new IllegalArgumentException("The courseType argument is required");
        if (minRunDate == null) throw new IllegalArgumentException("The minRunDate argument is required");
        if (maxRunDate == null) throw new IllegalArgumentException("The maxRunDate argument is required");
        EntityManager em = Course.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Course AS o WHERE o.courseType = :courseType AND o.runDate BETWEEN :minRunDate AND :maxRunDate", Long.class);
        q.setParameter("courseType", courseType);
        q.setParameter("minRunDate", minRunDate);
        q.setParameter("maxRunDate", maxRunDate);
        return ((Long) q.getSingleResult());
    }
    
    public static Long Course.countFindCoursesByNameLike(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        name = name.replace('*', '%');
        if (name.charAt(0) != '%') {
            name = "%" + name;
        }
        if (name.charAt(name.length() - 1) != '%') {
            name = name + "%";
        }
        EntityManager em = Course.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Course AS o WHERE LOWER(o.name) LIKE LOWER(:name)", Long.class);
        q.setParameter("name", name);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<Course> Course.findCoursesByCourseTypeAndRunDateBetween(CourseTypeEnum courseType, Date minRunDate, Date maxRunDate) {
        if (courseType == null) throw new IllegalArgumentException("The courseType argument is required");
        if (minRunDate == null) throw new IllegalArgumentException("The minRunDate argument is required");
        if (maxRunDate == null) throw new IllegalArgumentException("The maxRunDate argument is required");
        EntityManager em = Course.entityManager();
        TypedQuery<Course> q = em.createQuery("SELECT o FROM Course AS o WHERE o.courseType = :courseType AND o.runDate BETWEEN :minRunDate AND :maxRunDate", Course.class);
        q.setParameter("courseType", courseType);
        q.setParameter("minRunDate", minRunDate);
        q.setParameter("maxRunDate", maxRunDate);
        return q;
    }
    
    public static TypedQuery<Course> Course.findCoursesByCourseTypeAndRunDateBetween(CourseTypeEnum courseType, Date minRunDate, Date maxRunDate, String sortFieldName, String sortOrder) {
        if (courseType == null) throw new IllegalArgumentException("The courseType argument is required");
        if (minRunDate == null) throw new IllegalArgumentException("The minRunDate argument is required");
        if (maxRunDate == null) throw new IllegalArgumentException("The maxRunDate argument is required");
        EntityManager em = Course.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM Course AS o WHERE o.courseType = :courseType AND o.runDate BETWEEN :minRunDate AND :maxRunDate");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<Course> q = em.createQuery(queryBuilder.toString(), Course.class);
        q.setParameter("courseType", courseType);
        q.setParameter("minRunDate", minRunDate);
        q.setParameter("maxRunDate", maxRunDate);
        return q;
    }
    
    public static TypedQuery<Course> Course.findCoursesByNameLike(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        name = name.replace('*', '%');
        if (name.charAt(0) != '%') {
            name = "%" + name;
        }
        if (name.charAt(name.length() - 1) != '%') {
            name = name + "%";
        }
        EntityManager em = Course.entityManager();
        TypedQuery<Course> q = em.createQuery("SELECT o FROM Course AS o WHERE LOWER(o.name) LIKE LOWER(:name)", Course.class);
        q.setParameter("name", name);
        return q;
    }
    
    public static TypedQuery<Course> Course.findCoursesByNameLike(String name, String sortFieldName, String sortOrder) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        name = name.replace('*', '%');
        if (name.charAt(0) != '%') {
            name = "%" + name;
        }
        if (name.charAt(name.length() - 1) != '%') {
            name = name + "%";
        }
        EntityManager em = Course.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM Course AS o WHERE LOWER(o.name) LIKE LOWER(:name)");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<Course> q = em.createQuery(queryBuilder.toString(), Course.class);
        q.setParameter("name", name);
        return q;
    }
    
}
