package pagesTests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import baseConfig.Config;

public class Extents extends Config{

	public Extents() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeSuite
	public void ExtentReport() {
		
		
		 extent =new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Rest_Assured\\TestReports\\indexRep.html", true);
		 extent.addSystemInfo("TesterName: ", "Ahmed");
		 
		
	}
	
	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}
}
