package testBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import testListeners.WebDriverEventListeners;
import testUtils.Screenshot;


public class Basic {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListeners listener;

	



	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public Basic() throws IOException {

		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\SCowTestKeda\\TestData\\prop.properties");
		prop.load(fis);

	}

	@Parameters({"Browseris"})
	@BeforeClass
	public void before_Method(String browser, Method method) {

		extent.startTest(method.getName());

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\SCowTestKeda\\TestData\\chromedriver.exe");

			ChromeOptions option=new ChromeOptions();

			driver=new ChromeDriver(option);

			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			option.addArguments("--incognito");
			option.addArguments("--mute-audeo");

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();



		}


		else if(browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\SCowTestKeda\\TestData\\geckodriver.exe");

			driver=new FirefoxDriver();

		}

		else {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}


		listener=new WebDriverEventListeners();
		e_driver=new EventFiringWebDriver(driver);
		e_driver.register(listener);

	}



	@AfterClass
	public void After_Class() {



		driver.close();

	}

	@AfterMethod
	public void after_Method(Method method, ITestResult result) throws IOException {

		Screenshot.takeShot(method.getName());
		
		
			if (result.getStatus()==ITestResult.SUCCESS) {

				logger.log(LogStatus.PASS, "Test Passes");
				logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
				logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

			}else if (result.getStatus()==ITestResult.FAILURE) {

				logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());
				logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
				logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

			}else {
				logger.log(LogStatus.SKIP,"test skipped");
				
			}


	}

	
	

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}









}
