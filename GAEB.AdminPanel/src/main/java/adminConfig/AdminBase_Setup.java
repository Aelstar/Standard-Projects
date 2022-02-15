package adminConfig;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import adminListeners.FiringEventListeners;
import adminRecords.ScreenShot;



public class AdminBase_Setup {


	public static Properties prop;
	public static WebDriver driver;
	public static ChromeOptions option;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static EventFiringWebDriver e_driver;
	public static FiringEventListeners listener;


	public AdminBase_Setup() throws IOException {

		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB.AdminPanel\\TestData\\properties.properties");
		prop.load(fis);
	
	}



	@BeforeMethod
	@Parameters({"browser"})
	public void before_Method(String browser, Method method) {

		logger=extent.startTest(method.getName());


		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB.AdminPanel\\src\\main\\java\\adminConfig\\chromedriver.exe");
			option=new ChromeOptions();

			driver=new ChromeDriver(option);


			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			option.addArguments("incoginito");
			option.addArguments("--mute-audio");

		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB.AdminPanel\\src\\main\\java\\adminConfig\\geckodriver.exe");

			driver=new FirefoxDriver();


		}


		e_driver=new EventFiringWebDriver(driver);
		listener=new FiringEventListeners();
		e_driver.register(listener);




		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();

		driver.get(prop.getProperty("URL"));

	}

	
	

@AfterMethod
	public void after_Method(Method method, ITestResult result) throws IOException {

		ScreenShot.TakeShot(method.getName());

		if (result.getStatus()==ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test Passes");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			//logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

		}else if (result.getStatus()==ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());
			logger.log(LogStatus.FAIL,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			//logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");


		}else {
			logger.log(LogStatus.SKIP,"test skipped .........");

		}


		driver.close();

	}
	


	@DataProvider
	public  Object[][] dataProvider() throws IOException {
		
		Object[][]data =ExcelData.getExcel("ExtractorExcel");
		return data;
		
	}



}