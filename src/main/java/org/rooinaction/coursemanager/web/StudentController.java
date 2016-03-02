package org.rooinaction.coursemanager.web;
import org.rooinaction.coursemanager.model.Student;
import org.springframework.roo.addon.web.mvc.controller.annotations.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.annotations.json.RooWebJson;

@RequestMapping("/students")
@Controller
@RooWebScaffold(path = "students", formBackingObject = Student.class)
@RooWebJson(jsonObject = Student.class)
public class StudentController {
}
