package com.sitetest;

import java.util.concurrent.TimeUnit;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;





public class First_Session {

	//|qacart|Test123!|

	public static WebDriver driver;
	@BeforeSuite
	public void beforesuitee() {

		System.out.println("---------before Suite");

	}

	@AfterSuite
	public void afterSuite() {

		System.out.println("--------after Suite");

	}


	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void SetUp_Site() {


		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


		//WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver(option);


		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://197.168.1.39:5000/");
	}

	@AfterMethod
	public void BeforeMothd() {

		driver.quit();
		System.out.println("done");

	}

	@Test(priority = 1, enabled=true, groups= {"E2E", "sainty"})
	public void getURLTest() {

		driver.get("http://197.168.1.39:5000/");

		System.out.println(driver.getCurrentUrl());


	}

	@Test(priority = 3, groups= {"E2E"}, dataProvider="myData")
	public static void LoginPageTest(String username, String passwords)  {

		WebElement userName= driver.findElement(new ByIdOrName("Username"));

		WebElement password=driver.findElement(new ByIdOrName("Password"));

		WebElement loginButton=driver.findElement(new ByIdOrName("button"));


		userName.sendKeys(username);
		password.sendKeys(passwords);
		loginButton.click();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		@SuppressWarnings("deprecation")
		WebDriverWait wait=new  WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));

	}


	@Test(priority=2, enabled=true)
	public void ensureLoginDone() {


		WebElement logo=driver.findElement(By.xpath("//img[@src='/gaeb-dashboard/img/logo-login.png']"));

		boolean actualResult=logo.isDisplayed();
		boolean expectedResult=true;
		Assert.assertEquals(actualResult, expectedResult);


		System.out.println(logo.isDisplayed());
		System.out.print("Status Test is \t");
		System.out.println(actualResult=expectedResult);

	}

	@Test(priority = 4, enabled=true)
	public void get_Title() {

		LoginPageTest("username", "passwords"  );

		WebElement logo=driver.findElement(By.xpath("//img[@src='/gaeb-dashboard/img/logo-login.png']"));

		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(logo));

		String actualresult=driver.getTitle();
		String expectedresult="الهيئة العامة للأبنية التعليمية";

		Assert.assertEquals(actualresult, expectedresult, "not title same");

		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualresult, expectedresult,"this soft assert not equals");

		System.out.println(driver.getTitle());
		softAssert.assertAll();
		//		driver.switchTo().frame(0);
		//		driver.switchTo().parentFrame();
		//		driver.switchTo().defaultContent();


	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("--------Before Test");
	}
	@AfterTest
	public void afterTest() {

		System.out.println("----------After Test");

	}


}
