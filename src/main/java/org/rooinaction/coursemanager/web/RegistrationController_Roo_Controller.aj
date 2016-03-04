// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.rooinaction.coursemanager.db.RegistrationRepository;
import org.rooinaction.coursemanager.db.StudentRepository;
import org.rooinaction.coursemanager.model.Registration;
import org.rooinaction.coursemanager.service.CourseService;
import org.rooinaction.coursemanager.web.RegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect RegistrationController_Roo_Controller {
    
    @Autowired
    RegistrationRepository RegistrationController.registrationRepository;
    
    @Autowired
    CourseService RegistrationController.courseService;
    
    @Autowired
    StudentRepository RegistrationController.studentRepository;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String RegistrationController.create(@Valid Registration registration, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, registration);
            return "registrations/create";
        }
        uiModel.asMap().clear();
        registrationRepository.save(registration);
        return "redirect:/registrations/" + encodeUrlPathSegment(registration.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String RegistrationController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Registration());
        return "registrations/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String RegistrationController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("registration", registrationRepository.findOne(id));
        uiModel.addAttribute("itemId", id);
        return "registrations/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String RegistrationController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("registrations", Registration.findRegistrationEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) registrationRepository.count() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("registrations", Registration.findAllRegistrations(sortFieldName, sortOrder));
        }
        return "registrations/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String RegistrationController.update(@Valid Registration registration, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, registration);
            return "registrations/update";
        }
        uiModel.asMap().clear();
        registrationRepository.save(registration);
        return "redirect:/registrations/" + encodeUrlPathSegment(registration.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String RegistrationController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, registrationRepository.findOne(id));
        return "registrations/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String RegistrationController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Registration registration = registrationRepository.findOne(id);
        registrationRepository.delete(registration);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/registrations";
    }
    
    void RegistrationController.populateEditForm(Model uiModel, Registration registration) {
        uiModel.addAttribute("registration", registration);
        uiModel.addAttribute("courses", courseService.findAllCourses());
        uiModel.addAttribute("students", studentRepository.findAll());
    }
    
    String RegistrationController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
