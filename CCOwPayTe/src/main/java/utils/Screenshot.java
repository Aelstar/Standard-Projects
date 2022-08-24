package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import configrations.BaseTest;

public class Screenshot extends BaseTest {

	
	
	public Screenshot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void TakeScreenShot(String name) throws IOException  {
		
		
		File srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsOuts\\"+ name+".png"));
		
	}
}
