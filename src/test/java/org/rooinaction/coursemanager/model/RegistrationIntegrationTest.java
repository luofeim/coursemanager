package org.rooinaction.coursemanager.model;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.rooinaction.coursemanager.db.CourseRepository;
import org.rooinaction.coursemanager.db.OfferingRepository;
import org.rooinaction.coursemanager.db.RegistrationQueryRepository;
import org.rooinaction.coursemanager.db.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.test.annotations.RooIntegrationTest;

@RooIntegrationTest(entity = Registration.class)
public class RegistrationIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    OfferingRepository offeringRepository;

    @Autowired
    RegistrationQueryRepository registrationQueryRepository;
    
    @Test
    public void testFindStudentRegistrationForOfferingsInDateRange() {
        Registration registration = dod.getNewTransientRegistration(37);

        Student student = dod.studentDataOnDemand.getNewTransientStudent(38);
        registration.setStudent(student);
        
        Course course = dod.courseDataOnDemand.getNewTransientCourse(39);
        registration.setCourse(course);
        
        Offering offering = dod.offeringDataOnDemand.getNewTransientOffering(40);
        registration.setOffering(offering);
        
        studentRepository.saveAndFlush(student);
        courseRepository.saveAndFlush(course);
        offeringRepository.saveAndFlush(offering);
        registrationRepository.saveAndFlush(registration);
        
        List<Registration> registrationList = registrationQueryRepository.findRegistrationsByStudent(student.getId(), offering.getOfferDate(), offering.getOfferDate()).getResultList();
        Assert.assertEquals("Find method for 'Registration' returned the incorrect account", 1, registrationList.size());
        
        registration = registrationList.get(0);
        Assert.assertEquals("Find method for 'Registration' returned the incorrect student id", student.getId(), registration.getStudent().getId());
        Assert.assertEquals("Find method for 'Registration' returned the incorrect offering date", offering.getOfferDate(), registration.getOffering().getOfferDate());
    }
}
