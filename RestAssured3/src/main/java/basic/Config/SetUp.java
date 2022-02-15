package basic.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebListener;
import testUtils.ScreenRecord;

public class SetUp {
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static EventFiringWebDriver e_driver;
	
	public static WebListener listner;
	
	
	public SetUp() throws IOException {
		
		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\RestAssured3\\TestData\\prop.properties");
		
		prop.load(fis);
		
	}
	
	@Given("open browser")
	@Parameters({"browser"})
	@BeforeMethod
	public void before_Method(Method method, String browsers) throws InterruptedException {
		
		logger=extent.startTest(method.getName());
		
		if (browsers.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\RestAssured3\\TestData\\chromedriver.exe");
			
			ChromeOptions option =new ChromeOptions();
			option.addArguments("--mute-audio");
			option.addArguments("--incognito");
			
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			 driver=new ChromeDriver(option);
			
			
			 
		}
		else if(browsers.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\RestAssured3\\TestData\\geckodriver.exe");
		
		 driver=new FirefoxDriver();
				
		
		}
		else if(browsers.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			
			driver=new InternetExplorerDriver();
		
		}
		else {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
			
		}
			
			
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	
		e_driver=new EventFiringWebDriver(driver);
		
		listner=new WebListener();
		e_driver.register(listner);
		Thread.sleep(2000);
	}
	
	
	@Then("link open Successful")
	@AfterMethod
	public void after_Method(Method method, ITestResult result) throws IOException {
		
		ScreenRecord.ScreenShot(method.getName());
		
		if (result.getStatus()==ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test Passes");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

		}else if (result.getStatus()==ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");


		}else {
			logger.log(LogStatus.SKIP,"test skipped");
			
		}
		driver.close();
		
	}
	

}
