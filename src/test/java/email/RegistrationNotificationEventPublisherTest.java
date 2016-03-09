package email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rooinaction.coursemanager.email.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext.xml",
		"classpath:/META-INF/spring/applicationContext-jpa.xml",
		"classpath:/META-INF/spring/applicationContext-jms.xml" })
public class RegistrationNotificationEventPublisherTest {
	@Autowired
	private NotificationService notificationService;

	@Test
	public void verifyThatRegistrationNotificationIsSuccessful() {
		// Send e-mail notification
		String mailTo = "908994112@qq.com";
		String message = "Registration Successful.";
		notificationService.sendMessage(mailTo, message);
	}
}
