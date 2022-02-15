package records;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseConfig.Config;

public class SnapShot extends Config{

	
	
	public SnapShot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void Screen(String name) throws IOException {
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Rest_Assured\\TestReports\\"+name+".png"),true);
		
	}
}
