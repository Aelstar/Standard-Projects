package testCases;

import java.io.IOException;


import org.testng.annotations.Test;

import baseConfig.SetUp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testPages.LoginPage;

public class LoginPageTest extends SetUp{

	
	LoginPage login;
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void Test1() {
		
		System.out.println("Test 1");
	}
	
	@Test
	public void Test3() throws Exception {
		
		 login=new LoginPage();
		 login.getTitle();
		 
	}
	
	
	
	
	
	
	

@Given("I want to Login by valid user")
public void i_want_to_login_by_valid_user() {
	
	login.getURL();
	

	
}

@When("I open browser login by {string}  and {string}valid credintials")
public void i_open_browser_login_by_and_password_valid_credintials(String user, String passw) {
	System.out.println("by variables");
	
//	WebElement Username=	driver.findElement(By.name("username"));
//	WebElement Password=	driver.findElement(By.name("password"));
//	WebElement Loginbutton=	driver.findElement(By.xpath("//input[@value='Login']"));
//	Username.sendKeys(user);
//	Password.sendKeys(passw);
//	Loginbutton.click();
	login.performLogin(user, passw);

}



@When("I open browser login by valid credintials outline{string} and {string}")
public void i_open_browser_login_by_valid_credintials_outline(String userr, String passwo) {
	System.out.println("by outline");
	login.performLogin(userr, passwo);
}

@When("I open browser login by valid credintials userName and Password")
public void i_open_browser_login_by_valid_credintials_datatable(DataTable datatable) {
	login.performLogin(datatable.cell(0, 0),datatable.cell(0, 1));
	login.performLogin(datatable.cell(1, 0),datatable.cell(1, 1));
	
}


@Then("user login sucessfully")
public void user_login_sucessfully() {
  System.out.println("user login succ");
  
}
	
	
	
}
