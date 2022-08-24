package test.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basics.features.MainConfig;

public class LoginPage extends MainConfig{

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="")
	WebElement element;

}
