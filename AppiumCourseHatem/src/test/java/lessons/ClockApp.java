package lessons;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClockApp {
	AndroidDriver driver;


	@Test
	public void Clock() throws MalformedURLException {



		DesiredCapabilities caps=new DesiredCapabilities();


		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4XLAPI28");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.deskclock");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.deskclock.DeskClock");
		//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("com.google.android.deskclock:id/fab")).click();
		//driver.findElementByAccessibilityId("com.google.android.deskclock:id/fab").click();
		//	driver.findElement(By.className("android.widget.ImageButton")).click();	
		driver.findElement(By.className("android.widget.TextView")).click();

		System.out.println("click done");
		driver.findElement(By.className("android.widget.TextView")).getLocation();
		driver.findElement(By.className("android.widget.TextView")).getSize();
		driver.findElement(By.className("android.widget.TextView")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(""));
		driver.rotate(ScreenOrientation.PORTRAIT);
		driver.lockDevice();
		driver.unlockDevice();
		System.out.println(driver.isDeviceLocked());
		driver.rotate(ScreenOrientation.PORTRAIT);
		driver.quit();
		driver.hideKeyboard();
		

	}

}
