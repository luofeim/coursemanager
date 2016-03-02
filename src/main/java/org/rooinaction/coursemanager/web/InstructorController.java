package org.rooinaction.coursemanager.web;
import org.rooinaction.coursemanager.model.Instructor;
import org.springframework.roo.addon.web.mvc.controller.annotations.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.annotations.json.RooWebJson;

@RequestMapping("/instructors")
@Controller
@RooWebScaffold(path = "instructors", formBackingObject = Instructor.class)
@RooWebJson(jsonObject = Instructor.class)
public class InstructorController {
}
