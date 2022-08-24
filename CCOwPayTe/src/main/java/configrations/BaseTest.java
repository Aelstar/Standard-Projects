package configrations;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.Webdriverlisteners;
import utils.Screenshot;



public class BaseTest {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports extent;
	public static Webdriverlisteners listener;
	public static EventFiringWebDriver e_driver;


	public BaseTest() throws IOException {

		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsIn\\proper.properties");
		prop.load(fis);

	}

	@Parameters({"Browser"})
	@BeforeMethod
	public void beforeStartTest(String browser, Method method ) throws InterruptedException {


		logger=extent.startTest(method.getName());


		if(browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsIn\\chromedriver.exe");

			ChromeOptions option=new ChromeOptions();
			option.addArguments("--incognito");
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver=new ChromeDriver(option);
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",  "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsIn\\geckodriver.exe");
			driver=new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsIn\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();

		}

		else {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}


		e_driver=new EventFiringWebDriver(driver);
		listener=new Webdriverlisteners();
		e_driver.register(listener);


		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		
		

		driver.get(prop.getProperty("URL2"));


Thread.sleep(6000);

LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
// Retrieving all log 
List<LogEntry> logs= entry.getAll();
// Print one by one
for(LogEntry e: logs)
{
	System.out.println(e);
}

// Printing details separately 
for(LogEntry e: logs)
{
	System.out.println("Message is: " +e.getMessage());
	System.out.println("Level is: " +e.getLevel());
}



	}





	@AfterMethod
	public void after_Method(ITestResult result, Method method) throws IOException {

		Screenshot.TakeScreenShot(method.getName());


		if(result.getStatus()==ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test Passes");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

		}

		else if(result.getStatus()==ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");

		}

		else {
			logger.log(LogStatus.SKIP,"test skipped");

		}

		driver.close();
	}

}
