package org.rooinaction.coursemanager.model;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.roo.addon.test.annotations.RooIntegrationTest;

@RooIntegrationTest(entity = Course.class)
public class CourseIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

    /* 
     * 测试：name == "ray" && listPrice == 99.0 ==>触发：验证失败
    */
    @Test(expected = ConstraintViolationException.class)
    public void testMultiFieldsValidation() {
    	Course course = dod.getNewTransientCourse(25);
    	
    	course.setName("Ray");
    	dod.setListPrice(course, 99);
    	
        course.persist();
    }
    
}
