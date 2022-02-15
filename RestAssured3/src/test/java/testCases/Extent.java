package testCases;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import basic.Config.SetUp;

public class Extent extends SetUp{

	public Extent() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@BeforeSuite
	public void ExtentsRep() {
		
		
		extent=new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\RestAssured3\\OutReports\\indexRep.html",true);
		extent.addSystemInfo("Tester", "Ahmed");
		
	}
	
	@AfterSuite
	public void after_Suite() {
		
		extent.flush();
		
	}

}
