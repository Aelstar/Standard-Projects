package gaeb_testCases;

import org.testng.annotations.Test;

import gaeb_Pages.LoginPage;
import gaeb_TestBase.Setup_Base;

public class LoginPageTest extends Setup_Base{

	public LoginPageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void getTitle() {
		
		LoginPage.getTitle();
	
	}

}
