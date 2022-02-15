package gaeb_config;




import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import gaeb_TestBase.Setup_Base;

public class ScreenShot extends Setup_Base{

	
	public ScreenShot() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public static void SnapShots(String name) throws Exception {
		
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB_Demo\\outputReports\\"+name+".png"));
	
		
	}
}
