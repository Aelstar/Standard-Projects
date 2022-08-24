package lessons;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppiumBasics {



	@Test
	public void setUpAppium() throws MalformedURLException {

//
//		DesiredCapabilities caps=new DesiredCapabilities();
//
//		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Ahmed_Abdelstar");
//		
//		caps.setCapability(MobileCapabilityType.NO_RESET, false);
//
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
//
//		WebDriverManager.chromedriver().setup();
//		caps.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getDownloadedDriverPath());
//
//		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//
////		ChromeOptions options = new ChromeOptions();
////		options.setExperimentalOption("androidKeepAppDataDir", true);
////		caps.setCapability(ChromeOptions.CAPABILITY, options);
//
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//		driver.get("https://google.com");

		 DesiredCapabilities appCapabilities = new DesiredCapabilities();
		    appCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	//	 appCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		    appCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4XLAPI28");
		    appCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		    appCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		  //  WebDriverManager.chromedriver().clearPreferences();
		//    WebDriverManager.chromedriver().setup();	
		   // appCapabilities.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getBinaryPath());
		   ChromeOptions options = new ChromeOptions();
		//   options.setExperimentalOption("androidKeepAppDataDir", true);
		 //  appCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), appCapabilities);
		  
		    driver.get("gggg");
driver.navigate().to("wwww");

		
	
		

		
		
		
		
	}

}
