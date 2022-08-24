package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import basics.BasicClass;

public class ScreenShot extends BasicClass{

	
	public ScreenShot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void TakeScreen(String name) throws IOException {
		
		
File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(file, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CowpayTest\\TestDataOut\\"+name+".png"));

	}
}
