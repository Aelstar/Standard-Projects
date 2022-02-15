package gaeb_config;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import gaeb_TestBase.Setup_Base;

public class ExtentReport extends Setup_Base {

	

		
		public ExtentReport() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

		@BeforeSuite
		public void beforeSuite() {
			System.out.println("before Suite...........");
			
			extent=new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB_Demo\\outputReports\\index.html", false);
			extent.addSystemInfo("Teste", "Abdelstar");
			

		}

		@AfterSuite
		public void afterSuite() {

extent.flush();
		}
	}

