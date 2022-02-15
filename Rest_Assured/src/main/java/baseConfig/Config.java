package baseConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import listeners.Weblisteners;
import records.SnapShot;

public class Config {

	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public static EventFiringWebDriver e_driver;
	public static Weblisteners listener;
	
	public Config() throws IOException {
		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Rest_Assured\\TestData\\file.properties");
		prop.load(fis);
		
		
	
	}
	
@BeforeMethod
@Parameters({"browser"})
	public void SetUp(Method method,String browsers) throws InterruptedException {
		
	logger=extent.startTest(method.getName());
	
	
		if (browsers.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Rest_Assured\\TestData\\chromedriver.exe");
			
			ChromeOptions option=new ChromeOptions();
			
			 driver=new ChromeDriver(option);
			
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			option.addArguments("--mute-audio");
			option.addArguments("--incognito");
			
		}
		else if(browsers.equalsIgnoreCase("firfox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Rest_Assured\\TestData\\geckodriver.exe");
			
			driver=new FirefoxDriver();
			
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		e_driver=new EventFiringWebDriver(driver);
		  listener=new  Weblisteners();
		  e_driver.register(listener);
		  
		 Thread.sleep(3000);
		
	}


@AfterMethod
public void afterMethod(Method method, ITestResult result) throws IOException {
	
	SnapShot.Screen(method.getName());
	
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
