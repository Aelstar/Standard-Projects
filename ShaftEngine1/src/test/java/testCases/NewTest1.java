package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;

public class NewTest1 {
  @Test
  public void f() {
	  
	  
	  WebDriver driver=DriverFactory.getDriver();
	 // BrowserActions.navigateToURL(driver, "https://github.com/MohabMohie/using_SHAFT_ENGINE/blob/master/pom.xml");
	  BrowserActions.navigateToURL(driver, "https://github.com/MohabMohie/using_SHAFT_ENGINE/blob/master/pom.xml");
  }
}
