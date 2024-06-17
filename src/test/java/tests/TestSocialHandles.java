package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;

public class TestSocialHandles extends Browser{
	
	
	@Test(priority = 2)
	public void testXHandle() {
		HomePage home= new HomePage(driver);
		home.scrollToBottom(driver);
		
		Assert.assertTrue(home.checkTwtHandle());
	}
	
	
	@Test(priority = 3)
	public void testFBHandle() {
		HomePage home= new HomePage(driver);
		home.scrollToBottom(driver);
		
		Assert.assertTrue(home.checkFBHandle());
	}
	@Test(priority = 1)
	public void testYTHandle() {
		HomePage home= new HomePage(driver);
		home.scrollToBottom(driver);
		
		Assert.assertTrue(home.checkYTHandle());
	}
}
