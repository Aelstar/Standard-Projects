package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.ReportManager;

public class NewTest2 {
  @Test
  public void f() {
	  
	  
	  ReportManager.log("hggghgg");
	  
	  WebDriver driver=DriverFactory.getDriver();
	  
	  
  }
}
