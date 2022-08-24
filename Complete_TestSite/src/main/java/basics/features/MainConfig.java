package basics.features;

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
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainConfig {
	
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebDriver driver;
	
	
	
	
	
	public MainConfig() throws IOException {
		
		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Complete_TestSite\\TestData\\prop.properties");
		prop.load(fis);
		
	}
	

	@BeforeTest
	@Parameters({"browser"})
	public void Startbrowser(Method method, String browsers) {
		
		logger=extent.startTest(method.getName());
		
		
		if (browsers.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsIn\\chromedriver.exe");
			
			ChromeOptions option=new ChromeOptions();
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			option.addArguments("incignito");
			option.addArguments("mute-audio");
			
			
			driver=new ChromeDriver(option);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		else if(browsers.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Complete_TestSite\\TestData\\geckodriver.exe");
			driver=new FirefoxDriver();
			
			
		}
		else if(browsers.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
		}
		else {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		}
		
		
	}
	
	
	public void closeAllTest(ITestResult result, Method methd) {
		
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
		
		
		driver.close();
	}
}
