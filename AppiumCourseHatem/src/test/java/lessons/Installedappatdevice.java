package lessons;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Installedappatdevice {

	
	
	@Test
	public void insatlledapp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME	, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME	, "Pixel4XLAPI28");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME	, "Chrome");
		
//		WebDriverManager.chromedriver().setup();
//	caps.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getDownloadedDriverPath());

	
	AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
Thread.sleep(6000);

System.out.println("Navigating to udemy");
driver.get("https://www.facebook.com");
Thread.sleep(6000);
System.out.println("Lauchned successfully");
		Thread.sleep(6000);

	}
}
