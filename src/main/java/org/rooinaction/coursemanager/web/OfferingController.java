package org.rooinaction.coursemanager.web;
import org.rooinaction.coursemanager.model.Offering;
import org.springframework.roo.addon.web.mvc.controller.annotations.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.annotations.json.RooWebJson;

@RequestMapping("/offerings")
@Controller
@RooWebScaffold(path = "offerings", formBackingObject = Offering.class)
@RooWebJson(jsonObject = Offering.class)
public class OfferingController {
}
