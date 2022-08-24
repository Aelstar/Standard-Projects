package testUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBasics.Basic;

public class Screenshot extends Basic {
	
	
	public Screenshot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void takeShot(String name) throws IOException {
		
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\SCowTestKeda\\TestResults\\"+name+".png"));
	}

}
