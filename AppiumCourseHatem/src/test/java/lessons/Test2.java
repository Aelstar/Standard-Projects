package lessons;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test2 {
	

    

    @Test
    public void TestAppium() throws MalformedURLException{

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4XLAPI28");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");


        AndroidDriver     driver=new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), caps);

driver.get("https://mvnrepository.com/artifact/org.testng/testng/6.14.3");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



WebElement ele= driver.findElement(AppiumBy.accessibilityId(""));


WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));


wait.until(ExpectedConditions.elementToBeClickable(ele));


Wait<AndroidDriver> waits=new FluentWait<AndroidDriver>(driver).pollingEvery(Duration.ofSeconds(20)).withTimeout(Duration.ofSeconds(20)).ignoring(NoSuchElementException.class)
;
waits.until(ExpectedConditions.elementToBeClickable(ele));

    }

}
