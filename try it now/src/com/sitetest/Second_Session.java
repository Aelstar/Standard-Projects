package com.sitetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Second_Session {

	public static WebDriver driver;
	
	
	public Second_Session() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=  new FileInputStream("");
		prop.load(fis);
		prop.get(fis);
		
	}
	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");

		ChromeOptions option=new ChromeOptions();
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		option.addArguments("--incognito");
		option.addArguments("--mute-audio");


		 driver=new ChromeDriver(option);

		driver.get("http://197.168.1.39:5000");

		WebElement userName= driver.findElement(new ByIdOrName("Username"));

		WebElement password=driver.findElement(new ByIdOrName("Password"));

		WebElement loginButton=driver.findElement(new ByIdOrName("button"));


		userName.sendKeys("9999");
		password.sendKeys("P@ssw0rd");
		loginButton.click();


		WebElement  userInfo=driver.findElement(By.id("userInfo"));

		@SuppressWarnings("deprecation")
		WebDriverWait wait =new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(userInfo));

	}
	
@Parameters ({"URL"})
	@Test(priority=5, groups= {"E2E"})
	public void homePage() {
		
	String actualResult=	driver.getTitle();
		String expectedResult="";
		Assert.assertEquals(actualResult, expectedResult, "title is wrong");
		
		//SoftAssert softassert=new SoftAssert();
		//softassert.assertEquals(actualResult, expectedResult);
		//softassert.assertAll();
	}

@DataProvider
public Object[][] myData() {
	
	Object[][] Data=new Object[4][2];
	Data[0][0]="9999";
	Data[0][1]="P@ssw0rd";
	
	return Data;
	
}
	
	
	
}
