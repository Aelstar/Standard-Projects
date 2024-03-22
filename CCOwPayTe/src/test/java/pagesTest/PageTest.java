package pagesTest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import configrations.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Excel;

public class LoginPageTest extends BaseTest {

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	LoginPage login;
	HomePage homePage;

	@Test
	public void getTitleofPage() throws IOException {

		login=new LoginPage();
		login.get_Tilte();
		
	}

	
	
	
	@Test()
	
	public void loginConfirm() throws InterruptedException, IOException {
		
		homePage=login.LoginActions();
		Thread.sleep(3000);
		System.out.println("login Done");
		
		
	}
	
	
	@DataProvider
	public Object[][] ReadfromExcel() throws IOException {
		
		
		Object[][] Data=Excel.ExelReader("Sheet1");
		
		return Data;
		
		
	}
}
