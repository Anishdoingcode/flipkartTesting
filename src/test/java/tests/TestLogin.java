package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin extends Browser {

	@Test
	void testLogin() {
		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		home.openLoginPage();
		login.enterPhoneNumberAndSubmit("8741231231");
		Assert.assertTrue(login.checkSuccessMessage());

	}
	
	
	@Test
	void testInvalidLogin() {
		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		home.openLoginPage();
		login.enterPhoneNumberAndSubmit("1234567890");
		Assert.assertTrue(login.checkSuccessMessage());

	}

}
