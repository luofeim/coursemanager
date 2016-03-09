package org.rooinaction.coursemanager.web;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.rooinaction.coursemanager.email.NotificationService;
import org.rooinaction.coursemanager.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.roo.addon.web.mvc.controller.annotations.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.annotations.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.annotations.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/courses")
@Controller
@RooWebScaffold(path = "courses", formBackingObject = Course.class)
@RooWebFinder
@RooWebJson(jsonObject = Course.class)
public class CourseController {
	@Autowired
	private transient JmsTemplate jmsTemplate;

	public void sendMessage(Object messageObject) {
		jmsTemplate.convertAndSend(messageObject);
	}

	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String sendMessage(HttpServletRequest httpServletRequest) {
		sendMessage("send hello world......");
		return "message was sent......";
	}
	
	@Autowired
	private NotificationService notificationService;

	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String sendEmail(HttpServletRequest httpServletRequest) {
		// Send e-mail notification
		String mailTo = "908994112@qq.com";
		String message = "Registration Successful.";
		notificationService.sendMessage(mailTo, message);
		return "email was sent......";
	}

}
