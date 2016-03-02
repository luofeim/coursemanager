package org.rooinaction.coursemanager.web;
import org.rooinaction.coursemanager.model.TrainingProgram;
import org.springframework.roo.addon.web.mvc.controller.annotations.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.annotations.json.RooWebJson;

@RequestMapping("/trainingprograms")
@Controller
@RooWebScaffold(path = "trainingprograms", formBackingObject = TrainingProgram.class)
@RooWebJson(jsonObject = TrainingProgram.class)
public class TrainingProgramController {
}
