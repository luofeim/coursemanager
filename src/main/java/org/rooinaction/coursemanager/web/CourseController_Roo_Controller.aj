// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.web;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.rooinaction.coursemanager.db.TagRepository;
import org.rooinaction.coursemanager.db.TrainingProgramRepository;
import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.CourseTypeEnum;
import org.rooinaction.coursemanager.service.CourseService;
import org.rooinaction.coursemanager.web.CourseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect CourseController_Roo_Controller {
    
    @Autowired
    CourseService CourseController.courseService;
    
    @Autowired
    TagRepository CourseController.tagRepository;
    
    @Autowired
    TrainingProgramRepository CourseController.trainingProgramRepository;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String CourseController.create(@Valid Course course, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, course);
            return "courses/create";
        }
        uiModel.asMap().clear();
        courseService.saveCourse(course);
        return "redirect:/courses/" + encodeUrlPathSegment(course.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String CourseController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Course());
        return "courses/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String CourseController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("course", courseService.findCourse(id));
        uiModel.addAttribute("itemId", id);
        return "courses/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String CourseController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("courses", courseService.findCourseEntries(firstResult, sizeNo));
            float nrOfPages = (float) courseService.countAllCourses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("courses", courseService.findAllCourses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "courses/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String CourseController.update(@Valid Course course, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, course);
            return "courses/update";
        }
        uiModel.asMap().clear();
        courseService.updateCourse(course);
        return "redirect:/courses/" + encodeUrlPathSegment(course.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String CourseController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, courseService.findCourse(id));
        return "courses/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String CourseController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Course course = courseService.findCourse(id);
        courseService.deleteCourse(course);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/courses";
    }
    
    void CourseController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("course_rundate_date_format", "MM/dd/yyyy");
    }
    
    void CourseController.populateEditForm(Model uiModel, Course course) {
        uiModel.addAttribute("course", course);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("coursetypeenums", Arrays.asList(CourseTypeEnum.values()));
        uiModel.addAttribute("tags", tagRepository.findAll());
        uiModel.addAttribute("trainingprograms", trainingProgramRepository.findAll());
    }
    
    String CourseController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
