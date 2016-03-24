// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

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
import org.rooinaction.coursemanager.db.OfferingRepository;
import org.rooinaction.coursemanager.model.CourseDataOnDemand;
import org.rooinaction.coursemanager.model.InstructorDataOnDemand;
import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.OfferingDataOnDemand;
import org.rooinaction.coursemanager.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect OfferingDataOnDemand_Roo_DataOnDemand {
    
    declare @type: OfferingDataOnDemand: @Component;
    
    private Random OfferingDataOnDemand.rnd = new SecureRandom();
    
    private List<Offering> OfferingDataOnDemand.data;
    
    @Autowired
    CourseDataOnDemand OfferingDataOnDemand.courseDataOnDemand;
    
    @Autowired
    InstructorDataOnDemand OfferingDataOnDemand.instructorDataOnDemand;
    
    @Autowired
    OfferingService OfferingDataOnDemand.offeringService;
    
    @Autowired
    OfferingRepository OfferingDataOnDemand.offeringRepository;
    
    public Offering OfferingDataOnDemand.getNewTransientOffering(int index) {
        Offering obj = new Offering();
        setLocationName(obj, index);
        setOfferDate(obj, index);
        setUser(obj, index);
        return obj;
    }
    
    public void OfferingDataOnDemand.setLocationName(Offering obj, int index) {
        String locationName = "locationName_" + index;
        if (locationName.length() > 80) {
            locationName = locationName.substring(0, 80);
        }
        obj.setLocationName(locationName);
    }
    
    public void OfferingDataOnDemand.setOfferDate(Offering obj, int index) {
        Date offerDate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setOfferDate(offerDate);
    }
    
    public void OfferingDataOnDemand.setUser(Offering obj, int index) {
        User user = null;
        obj.setUser(user);
    }
    
    public Offering OfferingDataOnDemand.getSpecificOffering(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Offering obj = data.get(index);
        Long id = obj.getId();
        return offeringService.findOffering(id);
    }
    
    public Offering OfferingDataOnDemand.getRandomOffering() {
        init();
        Offering obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return offeringService.findOffering(id);
    }
    
    public boolean OfferingDataOnDemand.modifyOffering(Offering obj) {
        return false;
    }
    
    public void OfferingDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = offeringService.findOfferingEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Offering' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Offering>();
        for (int i = 0; i < 10; i++) {
            Offering obj = getNewTransientOffering(i);
            try {
                offeringService.saveOffering(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            offeringRepository.flush();
            data.add(obj);
        }
    }
    
}
