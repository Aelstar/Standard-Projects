package basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebDriverListeners;
import utils.ScreenShot;



public class BasicClass {

	public static Properties prop;
	public static WebDriver driver;
public static ExtentTest logger;
public static ExtentReports extent;
public static WebDriverListeners listener;
public static EventFiringWebDriver e_driver;


	public BasicClass() throws IOException {

		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CowpayTest\\TestDataIn\\propert.properties");
		prop.load(fis);

	}





@Parameters({"browsers"})
@BeforeTest
public void Before_Test(String Browser  ) {
	
	
	
	if(Browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CowpayTest\\TestDataIn\\chromedriver.exe");
		
				ChromeOptions option=new ChromeOptions();
				option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				option.addArguments("--mute-audio");
				option.addArguments("--incognito");
		
		
				driver=new ChromeDriver(option);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	 else if(Browser.equalsIgnoreCase("Firefox")) {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CowpayTest\\TestDataIn\\geckodriver.exe");
			
		driver=new FirefoxDriver();
		
	}else {
		
		WebDriverManager.chromedriver().setup();
		
	driver=new ChromeDriver();
	
	}
	
	
	driver.get(prop.getProperty("URL"));
	
Wait <WebDriver> wait=new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
//wait.until(ExpectedConditions.invisibilityOfAllElements(dd))
	
}


@BeforeMethod
public void before_Method(Method method) {
	
	logger=extent.startTest(method.getName());
	
	e_driver=new EventFiringWebDriver(driver);
	listener=new WebDriverListeners();
	e_driver.register(listener);
	
	
}


@AfterMethod
public void after_Method(Method method, ITestResult result) throws IOException {
	
	ScreenShot.TakeScreen(method.getName());
	
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

	
	
}

@AfterTest
public void after_Test() {
	
	driver.close();
}
}
