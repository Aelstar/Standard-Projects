package testPages;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import basic.Config.SetUp;

public class Rest1Page extends SetUp {

	public Rest1Page() throws IOException {
	PageFactory.initElements(driver, this);
	}

	
	public String get_URL() {
		
		
		driver.get(prop.getProperty("API"));
		String URL=driver.getCurrentUrl();
		System.out.println(URL);
		return URL;
	}
	
	
	public String get_Title() {
		
		driver.get(prop.getProperty("API"));
	String Title=driver.getTitle();
	System.out.println(Title);
	
	return Title;
	
	}
}
