package adminRecords;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import adminConfig.AdminBase_Setup;

public class ScreenShot extends AdminBase_Setup{
	
	
	public ScreenShot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void TakeShot(String name) throws IOException {
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB.AdminPanel\\OutputResults\\"+name+".png"),true);
	
		
	}

}
