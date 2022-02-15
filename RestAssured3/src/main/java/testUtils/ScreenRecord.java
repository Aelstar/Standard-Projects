package testUtils;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import basic.Config.SetUp;

public class ScreenRecord extends SetUp{

	
	public ScreenRecord() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void ScreenShot(String name) throws IOException {
		
		
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\RestAssured3\\OutReports\\"+name+".png"));
	}
}
