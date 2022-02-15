package com.sitetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import webdrivereventlistener.DriverEventListener;

@SuppressWarnings("deprecation")
public class Third_Session {
public static EventFiringWebDriver e_driver;
public static DriverEventListener weblistener;

	
	//http://197.168.1.39:5000/Account/Login
	@Test
	public void Setupforlogin() {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver=new ChromeDriver(option);
		
		
		e_driver= new EventFiringWebDriver (driver);
		weblistener=new DriverEventListener();
		e_driver.register(weblistener);
		driver=e_driver;
		
		
		
		driver.get("http://197.168.1.39:5000/Account/Login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(element));

		
		
	
		
		
	}
}
