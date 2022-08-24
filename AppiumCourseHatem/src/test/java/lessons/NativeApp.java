package lessons;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class NativeApp {
	
	
	@Test
	public void nativeTest() throws MalformedURLException {
		
		
		File app=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\AppiumCourseHatem\\target\\QAcart-To-Do.apk");
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 XL");
	caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

	
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
	
	
	}
	

}
