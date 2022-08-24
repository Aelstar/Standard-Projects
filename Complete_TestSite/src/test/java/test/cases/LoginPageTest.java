package test.cases;

import java.io.IOException;

import basics.features.MainConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageTest extends MainConfig{

	
	
	
	
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("i open browser and navigate to url")
	public void i_open_browser_and_navigate_to_url() {
	  
		
		
	}

	@When("i login by {string} and {string}")
	public void i_login_by_and(String username, String password) {
		
		
	   
	}

	@Then("I click at logout button")
	public void i_click_at_logout_button() {
	  
	}
}
