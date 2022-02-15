package adminTestCases;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import adminConfig.AdminBase_Setup;

public class ExtentReport extends AdminBase_Setup {

	
	public ExtentReport() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeSuite
	public void Extent() {
		
		 extent=new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB.AdminPanel\\OutputResults\\index.html",true);
		 extent.addSystemInfo("TesterName", "Ahmed");
		 
		
		
	}
	@AfterSuite
	public void afterSuite() {
		
		extent.flush();
	}
	

}
