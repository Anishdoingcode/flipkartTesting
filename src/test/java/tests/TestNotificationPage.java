package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;
import pages.NotificationPage;

public class TestNotificationPage extends Browser {

	@Test
	void testValidPin() throws InterruptedException {
		final Logger logger = LogManager.getLogger(TestPincode.class);
		HomePage home = new HomePage(driver);
		logger.info("opened homepage");
		NotificationPage notifPage = new NotificationPage(driver);
		home.goToNotification();
		logger.info("opened notification page");

		Assert.assertTrue(notifPage.verifyNotificationPage(), "customer care page did not open");

	}

}
