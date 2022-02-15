package testPages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import baseConfig.Config;

public class LoginPage extends Config{

	public LoginPage() throws IOException {
		
	PageFactory.initElements(driver, this);
	
	}

	
	public void getTitle() {
	driver.get(prop.getProperty("URL"));
		//driver.get("https://reqres.in/api/users?page=2");
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	public void getUrl() {
		//driver.get("https://reqres.in/api/users?page=2");

		driver.get(prop.getProperty("URL"));
		String url=driver.getCurrentUrl();
		System.out.println(url);
	}
}
