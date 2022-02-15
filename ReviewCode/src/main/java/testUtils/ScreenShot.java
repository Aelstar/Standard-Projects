package testUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import basics.Configs;

public class ScreenShot extends Configs {

	
	
	public  ScreenShot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void SnapShot(String name) throws IOException {
		
		
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewCode\\TestOutputs\\"+name+".png"));
		
	}
}
