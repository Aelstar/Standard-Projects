package gaeb_Pages;

import org.openqa.selenium.support.PageFactory;

import gaeb_TestBase.Setup_Base;

public class LoginPage extends Setup_Base {

	public LoginPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}
 
	
	
	public static String getTitle() {
		
		String Title=driver.getTitle();
		System.out.println(Title);
		return Title;
	}
}
