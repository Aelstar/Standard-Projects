package testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import baseConfig.SetUp;

public class ExtentRep extends SetUp{

	public ExtentRep() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void Extentreport() {
		
		extent =new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Cucumberwithmvn\\OutResult\\indexReport.html", true);
	extent.addSystemInfo("Teser", "Ahmed");
	
	}
	@AfterSuite
	public void afterSuite() {
		extent.flush();
		
	}
}
