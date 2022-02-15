package gaeb_TestBase;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import gaeb_config.ScreenShot;


public class Setup_Base {


	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ATUTestRecorder record;


	public Setup_Base() throws Exception {

		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB_Demo\\TestData\\properties.properties");
		prop.load(fis);

	}




	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test...........");

	}
	@AfterTest
	public void afterTest() {


	}
	
		@Parameters({"browser"})
		@BeforeMethod
		public void beforeMethod(String browsers, Method method) throws ATUTestRecorderException {
	
			logger=extent.startTest(method.getName());
	
	
			record=new ATUTestRecorder("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB_Demo\\outputReports", method.getName(), false);
			record.start();
	
	
			if (browsers.equalsIgnoreCase("Chrome")) {
	
				System.setProperty("webdriver.chrome.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");
	
				ChromeOptions option=new ChromeOptions();
				option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	
				driver=new ChromeDriver(option);
	
	
			}
			else if(browsers.equalsIgnoreCase("Firefox")) {
	
				System.setProperty("webdriver.gecko.driver", "D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\geckodriver-v0.29.0-win32\\geckodriver.exe");
	
				driver=new FirefoxDriver();
	
	
	
			}
	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
	
	
			driver.get(prop.getProperty("URL"));
	
	
	
		}
	@AfterMethod
	public void afterMethod(Method method, ITestResult result) throws Exception {


		ScreenShot.SnapShots(method.getName());

		record.stop();

		if (result.getStatus()==ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test Passes");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

		}else if (result.getStatus()==ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());


		}else {
			logger.log(LogStatus.SKIP,"test skipped");

		}


		driver.quit();

	}






}
