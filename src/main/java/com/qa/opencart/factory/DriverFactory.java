package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opncart.exceptions.BrowserException;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name is : "+ browserName);
		
		switch(browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("please provide correct browser..."+browserName);
			throw new BrowserException("No browser found..." +browserName);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		return driver;
	}
	
	public void initProp() {
		prop = new Properties();
		FileInputStream ip = new FileInputStream();
	}

}
