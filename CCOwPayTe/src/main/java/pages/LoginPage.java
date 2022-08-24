package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configrations.BaseTest;

public class LoginPage extends BaseTest{

	public LoginPage() throws IOException {
	PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//input[@name='Username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement Password;
	
	@FindBy(className="login-btn")
	WebElement LoginButton;
	
	
	
	
	public String get_Tilte() {
		

		String Title=driver.getTitle();
		System.out.println(Title);
		return Title;
		
	}
	
	
	
	
	public HomePage LoginActions() throws IOException {
		
		
		UserName.sendKeys(prop.getProperty("URL"));
		
		Password.sendKeys("test");
		
		LoginButton.click();
		
		return new HomePage();
		
	}
	
	
	
}
