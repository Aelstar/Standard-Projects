package testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import basics.Configs;

public class ExtentsTest extends Configs{

	public ExtentsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeSuite
	public void before_Suite() {
		
		extent=new 	ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewKeda\\testOuts\\index.html", true);
		extent.addSystemInfo("tester is","Abdelstar**");

	}
	
	
	@AfterSuite
	public void After_Suite() {
		
		extent.flush();
		
	}
}
