// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.rooinaction.coursemanager.db.InstructorRepository;
import org.rooinaction.coursemanager.db.OfferingRepository;
import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.service.CourseService;
import org.rooinaction.coursemanager.web.OfferingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect OfferingController_Roo_Controller {
    
    @Autowired
    OfferingRepository OfferingController.offeringRepository;
    
    @Autowired
    CourseService OfferingController.courseService;
    
    @Autowired
    InstructorRepository OfferingController.instructorRepository;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String OfferingController.create(@Valid Offering offering, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, offering);
            return "offerings/create";
        }
        uiModel.asMap().clear();
        offeringRepository.save(offering);
        return "redirect:/offerings/" + encodeUrlPathSegment(offering.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String OfferingController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Offering());
        return "offerings/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String OfferingController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("offering", offeringRepository.findOne(id));
        uiModel.addAttribute("itemId", id);
        return "offerings/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String OfferingController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("offerings", Offering.findOfferingEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) offeringRepository.count() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("offerings", Offering.findAllOfferings(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "offerings/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String OfferingController.update(@Valid Offering offering, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, offering);
            return "offerings/update";
        }
        uiModel.asMap().clear();
        offeringRepository.save(offering);
        return "redirect:/offerings/" + encodeUrlPathSegment(offering.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String OfferingController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, offeringRepository.findOne(id));
        return "offerings/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String OfferingController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Offering offering = offeringRepository.findOne(id);
        offeringRepository.delete(offering);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/offerings";
    }
    
    void OfferingController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("offering_offerdate_date_format", "MM/DD/YYYY");
    }
    
    void OfferingController.populateEditForm(Model uiModel, Offering offering) {
        uiModel.addAttribute("offering", offering);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("courses", courseService.findAllCourses());
        uiModel.addAttribute("instructors", instructorRepository.findAll());
    }
    
    String OfferingController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
