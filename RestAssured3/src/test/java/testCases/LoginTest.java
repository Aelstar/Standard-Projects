package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import basic.Config.SetUp;
import io.cucumber.java.en.When;
import testPages.LoginPage;

public class LoginTest extends SetUp{
LoginPage login;

	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@When(" get title of page")
	@Test 
	public void get_Title() throws IOException {
		
		login=new LoginPage();
		
		login.getTitle();
		
	}
	
	
	@When(" get URL of page")
	@Test
	public void get_Url() {
		
		login.getURL();
		
	}
	
}
