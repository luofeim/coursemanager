package org.rooinaction.coursemanager.web;
import org.rooinaction.coursemanager.model.Registration;
import org.springframework.roo.addon.web.mvc.controller.annotations.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.annotations.json.RooWebJson;

@RequestMapping("/registrations")
@Controller
@RooWebScaffold(path = "registrations", formBackingObject = Registration.class)
@RooWebJson(jsonObject = Registration.class)
public class RegistrationController {
}
