package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. Private By locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value=\'Login\']");
	private By forgetPWDLink= By.linkText("Forgotten Password");
	
	//2. public page class constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Public PAge Actions/Method
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login page title is: "+ title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Login page title is: "+ url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgetPWDLink).isDisplayed();
	}
	
	public String doLogin(String username, String pwd) {
		System.out.println("User credentials: username: "+username +" : "+pwd);
		driver.findElement(emailID).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return driver.getTitle();
	}

}
