package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}
	
	@Test
	public void loginPageURLTest() {
		String actUrl = loginPage.getLoginPageURL();
		Assert.assertTrue(actUrl.contains("route=account/login"));
	}
	
	@Test 
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test (priority = 2)
	public void doLoginTest() {
		String actTitle = loginPage.doLogin("test1@abc.com", "test@123");
		Assert.assertEquals(actTitle, "My Account");
	}

}
