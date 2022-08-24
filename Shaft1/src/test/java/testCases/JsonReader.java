package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;

public class JsonReader {
	
JSONFileManager jsonReader;
	
	
	@Test
	public void Exceldata() {
		
	jsonReader=new JSONFileManager(System.getProperty("testDataFolderPath")+"ExtractorData.json");
		
		WebDriver driver=DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver, "https://www.google.com/");
		ElementActions.type(driver, By.name("q"),jsonReader.getTestData("email"));
		
		System.out.println("done***");
		
	}
}
