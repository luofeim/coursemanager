// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.rooinaction.coursemanager.db.CourseRepository;
import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.CourseDataOnDemand;
import org.rooinaction.coursemanager.model.CourseTypeEnum;
import org.rooinaction.coursemanager.model.TrainingProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect CourseDataOnDemand_Roo_DataOnDemand {
    
    declare @type: CourseDataOnDemand: @Component;
    
    private Random CourseDataOnDemand.rnd = new SecureRandom();
    
    private List<Course> CourseDataOnDemand.data;
    
    @Autowired
    CourseRepository CourseDataOnDemand.courseRepository;
    
    public Course CourseDataOnDemand.getNewTransientCourse(int index) {
        Course obj = new Course();
        setCourseType(obj, index);
        setDescription(obj, index);
        setListPrice(obj, index);
        setMaximumCapacity(obj, index);
        setName(obj, index);
        setRunDate(obj, index);
        setTrainingProgram(obj, index);
        return obj;
    }
    
    public void CourseDataOnDemand.setCourseType(Course obj, int index) {
        CourseTypeEnum courseType = CourseTypeEnum.class.getEnumConstants()[0];
        obj.setCourseType(courseType);
    }
    
    public void CourseDataOnDemand.setDescription(Course obj, int index) {
        String description = "description_" + index;
        if (description.length() > 1000) {
            description = description.substring(0, 1000);
        }
        obj.setDescription(description);
    }
    
    public void CourseDataOnDemand.setListPrice(Course obj, int index) {
        BigDecimal listPrice = BigDecimal.valueOf(index);
        if (listPrice.compareTo(new BigDecimal("99999.99")) == 1) {
            listPrice = new BigDecimal("99999.99");
        }
        obj.setListPrice(listPrice);
    }
    
    public void CourseDataOnDemand.setMaximumCapacity(Course obj, int index) {
        Integer maximumCapacity = new Integer(index);
        if (maximumCapacity < 1 || maximumCapacity > 9999) {
            maximumCapacity = 9999;
        }
        obj.setMaximumCapacity(maximumCapacity);
    }
    
    public void CourseDataOnDemand.setName(Course obj, int index) {
        String name = "name_" + index;
        if (name.length() > 60) {
            name = name.substring(0, 60);
        }
        obj.setName(name);
    }
    
    public void CourseDataOnDemand.setRunDate(Course obj, int index) {
        Date runDate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setRunDate(runDate);
    }
    
    public void CourseDataOnDemand.setTrainingProgram(Course obj, int index) {
        TrainingProgram trainingProgram = null;
        obj.setTrainingProgram(trainingProgram);
    }
    
    public Course CourseDataOnDemand.getSpecificCourse(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Course obj = data.get(index);
        Long id = obj.getId();
        return courseRepository.findOne(id);
    }
    
    public Course CourseDataOnDemand.getRandomCourse() {
        init();
        Course obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return courseRepository.findOne(id);
    }
    
    public boolean CourseDataOnDemand.modifyCourse(Course obj) {
        return false;
    }
    
    public void CourseDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = courseRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Course' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Course>();
        for (int i = 0; i < 10; i++) {
            Course obj = getNewTransientCourse(i);
            try {
                courseRepository.save(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            courseRepository.flush();
            data.add(obj);
        }
    }
    
}
