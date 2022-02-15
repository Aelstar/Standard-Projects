package testRecords;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sitetest.Second_Session;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Record extends Second_Session {

	
	
	public Record() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void ScrenRecord() throws IOException {
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\try it now\\Records\\screen.png"));

		
	}
	
	
	public void video(String name) throws ATUTestRecorderException {
		
		ATUTestRecorder record=new ATUTestRecorder("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\try it now\\Records", name,false);
		record.start();
		record.stop();
	
	}
}
