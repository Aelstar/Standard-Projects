package testPages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import basic.Config.SetUp;

public class LoginPage extends SetUp{

	public LoginPage() throws IOException {
		PageFactory.initElements(driver,this);
		
	}

	
	
	
	public String getTitle() {
		
		driver.get(prop.getProperty("URL"));
		
		String Title=driver.getTitle();
		System.out.println(Title);
		return Title;
		
	}
	
	public String getURL() {
		
		driver.get(prop.getProperty("URL"));
	String URLis=driver.getCurrentUrl();
			
	System.out.println(URLis);
	return URLis;
	
	}
}
