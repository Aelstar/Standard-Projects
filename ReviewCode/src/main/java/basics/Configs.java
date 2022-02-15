package basics;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebListeners;
import testUtils.ExcelData;
import testUtils.ScreenShot;

public class Configs {

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions option;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebListeners weblistener;
	public static EventFiringWebDriver e_driver;
	
	
	public Configs() throws IOException {
		
		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewCode\\TestData\\properties.properties");
		prop.load(fis);
		
	}
	
	@BeforeMethod
	@Parameters({"browsers"})
	public void SetUp(String browser, Method method) throws InterruptedException {
		
		
		logger=extent.startTest(method.getName());
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewCode\\TestData\\chromedriver.exe");
		
			 option=new ChromeOptions();
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			 driver=new ChromeDriver(option);
			
			option.addEncodedExtensions("--mute-audio");
			option.addArguments("--incognito");
			
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("WebDriver.gecko.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewCode\\TestData\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		
		
		}
		else if(browser.equalsIgnoreCase("IE")) {
			
			
			System.setProperty("webdriver.ie.driver", "");
			
			driver =new InternetExplorerDriver();
			
		}
		else {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		
		
		
		
		 e_driver=new EventFiringWebDriver(driver);
		  weblistener=new WebListeners();
		  e_driver.register(weblistener);
		  
		 
		Thread.sleep(3000);
		
	}
	
	
	
	
	@AfterMethod
	public void closeMethod(ITestResult result, Method method) throws IOException {
		
		
		ScreenShot.SnapShot(method.getName());
		
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
	
	
	@DataProvider
	public Object[][] getdataprovider() throws IOException {
		
		Object data[][]=ExcelData.Ex_Data("Sheet1");
		return data;
		
	}
}
