package pagesTests;

import java.io.IOException;

import org.testng.annotations.Test;

import baseConfig.Config;
import testPages.LoginPage;

public class LoginTest extends Config{

	
	LoginPage login;
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void Test1() throws IOException {
		
		 login=new LoginPage();
	
		 login.getTitle();
		 
	}
	
	@Test
	public void Test2() {
		
		login.getUrl();
		
	}
	
	
}
