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

import testListeners.WebListener;
import testUtils.TakeShot;


public class SetUp {


	public static	WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebListener W_listener;
	public static EventFiringWebDriver e_driver;
	
	

	public SetUp() throws IOException {

		 prop=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Cucumberwithmvn\\TestData\\file.properties");
		prop.load(fis);

	}
	
	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(Method method, String Browser) {
		
logger=extent.startTest(method.getName());

		switch (Browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Cucumberwithmvn\\TestData\\chromedriver.exe");

			ChromeOptions option=new ChromeOptions();
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver=new ChromeDriver(option);
			
			option.addArguments("--mute-audio");
			option.addArguments("--incoginito");

			break;

		case "firfox":

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Cucumberwithmvn\\TestData\\geckodriver.exe");
			driver=new FirefoxDriver();

			break;

		}
		
		
		e_driver=new EventFiringWebDriver(driver);
		 W_listener=new WebListener();
		e_driver.register(W_listener);
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

		driver.get(prop.getProperty("URL"));
	}



	@AfterMethod
	public void afterMethod(Method method, ITestResult result) throws IOException {
		
		
		TakeShot.ScreenShot(method.getName());
		
		if (result.getStatus()==ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test Passes");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			//logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

		}else if (result.getStatus()==ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());
		

		}else {
			logger.log(LogStatus.SKIP,"test skipped");
			
		}
		
		driver.close();

	}
}
