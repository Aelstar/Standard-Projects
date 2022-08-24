package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basics.Configs;
import testUtils.GetData;

public class LoginTest extends Configs{
	
	
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider="readExcel")
	public void test1(String name,String passw) {
		
	driver.get(prop.getProperty("URL"));
		
	//driver.get("https://www.facebook.com/groups/Automatest");
		
		System.out.println(name+"/t"+passw);
		
		System.out.println("Test1 ******done");
		
	}

	
	
	
	@DataProvider
	public Object[][] readExcel() throws IOException {
		
		Object ExcelData[][]=GetData.read_Data("Sheet1");
		return ExcelData;
		
	}
}
