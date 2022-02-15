package testPages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseConfig.SetUp;

public class LoginPage extends SetUp{

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

	
	


	@FindBy(name="username")
			WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Loginbutton;
	
	
	
	
	public String getTitle() {
		
		String Title= driver.getTitle();
		System.out.println(Title);
		return Title;
		
	}
	
	
	
	public String getURL() {
		
		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);
		return currentURL;
		
	}
	
	
	public void performLogin(String userName, String passWord) {
		
		Username.sendKeys(userName);
		Password.sendKeys(passWord);
		Loginbutton.click();
		
	}
}
