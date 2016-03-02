package org.rooinaction.coursemanager.web;
import org.rooinaction.coursemanager.model.Tag;
import org.springframework.roo.addon.web.mvc.controller.annotations.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.annotations.json.RooWebJson;

@RequestMapping("/tags")
@Controller
@RooWebScaffold(path = "tags", formBackingObject = Tag.class)
@RooWebJson(jsonObject = Tag.class)
public class TagController {
}
