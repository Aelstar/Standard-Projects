package testCases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.shaft.api.RestActions.ParametersType;
import com.shaft.api.RestActions.RequestType;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ReportManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.ElementAttributeType;
import com.shaft.validation.Verifications;

import io.restassured.http.ContentType;





public class Ttest {

	@SuppressWarnings({  "removal", "deprecation" })
	@Test
	
	public void test11() {
		
		ReportManager.log("sadasd");
		WebDriver driver=DriverFactory.getDriver();
		
		BrowserActions.navigateToURL(driver, "http://197.168.1.39:5000/Account/Login");
		
		ElementActions.type(driver,By.xpath("//input[contains(@name, 'Username')]"),"54321");
		ElementActions.type(driver, By.xpath("//input[contains(@name, 'Password')]"), "P@ssw0rd");
		ElementActions.click(driver, By.xpath("//button[contains(@value, 'login')]"));
		
Assertions.assertEquals("Hi", ElementActions.getText(driver, By.xpath("")) );
Assertions.assertElementAttribute(driver, By.xpath(""),ElementAttributeType.TEXT, "sdff");

		
		//Actions action =new Actions(driver);
		//action.contextClick();
		
		//div[@class='col-md-2 col-sm-4']//img[@src='angie.jpg']/ancestor::a/following-sibling::p
		
		//Verifications.verifyElementMatches(driver, null, null);
	}
	
	
	public void TestAPI() {
		
		
		List<List<Object>>formdata=Arrays.asList(
				Arrays.asList("UserName","54321"),
				Arrays.asList("Password","P@ssw0rd"));
		
		DriverFactory.getAPIDriver("http://197.168.1.39:5000/")
		.buildNewRequest("Account/Login", RequestType.POST)
		.setTargetStatusCode(200)
		.setParameters(formdata, ParametersType.FORM)
		.setContentType(ContentType.URLENC)
		.performRequest();
		
	}
	
}
