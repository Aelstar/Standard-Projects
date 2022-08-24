package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;

public class ExcelRead {
	
ExcelFileManager excelReader;
	
	
	@Test
	public void Exceldata() {
		
		//excelReader=new ExcelFileManager(System.getProperty("testDataFolderPath")+"Extractor Data.xlsx");
		excelReader=new ExcelFileManager("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Shaft1\\src\\test\\resources\\testDataFiles\\Extractor Data.xlsx");
		WebDriver driver=DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver, "https://www.google.com/");
		ElementActions.type(driver, By.name("q"),excelReader.getCellData("Ahmed 1"));
		
		System.out.println("done***");
		
	}
}
