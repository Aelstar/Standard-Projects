package testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import testBasics.Basic;

public class ExtentReport extends Basic{

	public ExtentReport() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@BeforeSuite
	public void before_Suite() {

extent=new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\SCowTestKeda\\TestResults\\indexReport.html", false);
extent.addSystemInfo("Teser", "AhmedAbdelstar");

		
}
	@AfterSuite
	public void after_Suite() {
		
		extent.flush();
	}
}
