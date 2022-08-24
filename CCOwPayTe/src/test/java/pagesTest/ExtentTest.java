package pagesTest;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import configrations.BaseTest;

public class ExtentTest extends BaseTest{
	
	
	public ExtentTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void before_Suite() {
		
		 extent=new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsOuts\\reportResult.html", true);
		
		extent.addSystemInfo("TeserName", "ABdelstar");
		
		
	}
	
	@AfterSuite
	public void After_Suite() {
		
		extent.flush();
		
	}

}
