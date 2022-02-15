package testCases;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;

import basics.Configs;

public class ExtentTest extends Configs{

	public ExtentTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeSuite
	public void Report() {
		
		
		extent=new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewCode\\TestOutputs\\indexReport.html", true);
	
		
		extent.addSystemInfo("Tester", "Ahmed");
		
	}
	@AfterSuite
	public void afterSuite() {
		
		extent.flush();
	}

}
