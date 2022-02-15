package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases {
	
	public static WebDriver driver;
	
	
	//Ahmed@123
	//Ahmed.3bdelstar@gmail.com
	//https://classic.freecrm.com/index.html?e=1
	//https://ui.freecrm.com/
	
	@Given("user has account at active Directory")
	public void user_has_account_at_active_directory() {
		
	WebDriverManager.chromedriver().setup();
	
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	}

	@When("user login by valid username and password")
	public void user_login_by_valid_username_and_password() {
	  driver.get("https://cowpay.me/login");
		
	}
	    
	@Then("user directed to home page")
	public void user_directed_to_home_page() {
		
		System.out.println("Title *******************is :"+driver.getTitle());
		driver.close();
	}
	
	
	
	//**************** for data in variables
	
	@Given("open website and login by valid user")
	public void open_website_and_login_by_valid_user() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	 driver.get("https://ui.freecrm.com/");
	 
	}

	@When("login by valid {string} and {string} credentials")
	public void login_by_valid_and_credentials(String username, String password) throws InterruptedException {
	 driver.findElement(By.name("email")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.cssSelector(".button")).click();
	
	 
	}

	
	
	@Then("user login successfuully")
	public void user_login_successfuully() {
	  System.out.println("test case for variables data done");
	  
	  driver.close();
	  
	}
	
	
	
	

	//**************** for data in datatable
	
	@Given("open website and login by valid user dataTable")
	public void open_website_and_login_by_valid_user_dataTable() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	 driver.get("https://ui.freecrm.com/");
	 
	}

	@When("login by valid userName and Password credentials dataTable")
	public void login_by_valid_and_credentials_dataTable(DataTable table) {
	 driver.findElement(By.name("email")).sendKeys(table.cell(0, 0));
	 driver.findElement(By.name("password")).sendKeys(table.cell(0, 1));
	 driver.findElement(By.xpath("//*[text()='Login']")).click();
	 
	}

	
	
	@Then("user login successfuully datatable")
	public void user_login_successfuully_datatable() {
	  System.out.println("test case for datatable data done");
	 driver.close();
	  
	}
	
	
	
	
	

	//**************** for data in scenario outline

	@Given("open website and login by valid user scenario")
	public void open_website_and_login_by_valid_scenario() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	 driver.get("https://ui.freecrm.com/");
	 Thread.sleep(3000);
	}
	 
	@When("login by valid {string} and {string} credentials scenario")
	public void login_by_valid_and_credentials_scenario( String userName, String Password) {
	 driver.findElement(By.name("email")).sendKeys(userName);
	 driver.findElement(By.name("password")).sendKeys(Password);
	 driver.findElement(By.cssSelector("div[class='ui fluid large blue submit button']")).click();
	 
	}

	
	
	@Then("user login successfuully scenario")
	public void user_login_successfuully_scenario() {
	  System.out.println("test case for scenario data done");
	 driver.close();
	  
	}
	
}
