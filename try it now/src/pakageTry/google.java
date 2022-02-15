package pakageTry;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;




public class google {


	@SuppressWarnings("deprecation")
	public static void main(String[]args) {



		ChromeOptions option=new ChromeOptions();
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		option.addArguments("--incognito");
		option.addArguments("--mute-audio");

		System.setProperty("webdriver.chrome.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver=new ChromeDriver(option);
driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement goog=driver.findElement(By.name("q"));
		goog.sendKeys("android");


		WebElement sis=driver.findElement(By.tagName("ul"));

		List<WebElement>all=sis.findElements(By.tagName("li"));

		System.out.println(all.size());

		System.out.println(all.get(0).getText());

		for(int i=0; i<all.size(); i++) {

			System.err.println(all.get(i).getText());
		}


		driver.quit();

	}



}


