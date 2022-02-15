package sauceLab;

import java.util.HashMap;
import java.util.Map;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs {


	public static final String UserName="oauth-ahmed.3bdelstar-6ae3e";
	public static final String Access_Key="ff60ec63-6473-4895-b322-e71ec64bfa6c";
	//public static final String UserName="Ahmed_123456";
	public static final String URL="https://"+ UserName+":"+Access_Key+"@ondemand.us-west-1.saucelabs.com/wd/hub";


	public static void main(String[]args) throws Exception{
		//	System.setProperty("webdriver.chrome.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();


		//		DesiredCapabilities caps =new DesiredCapabilities.chrome();
		//		caps.setCapability("platform", "Windows 10");
		//		caps.setCapability("version", "latest");
		//		caps.setCapability("build", "myTestBuild");
		//		caps.setCapability("name", "GoogleTest");
		//		
		//		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);



		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("Windows 8");
		options.setBrowserVersion("latest");

		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", System.getenv("oauth-ahmed.3bdelstar-6ae3e"));
		sauceOptions.put("accessKey", System.getenv("ff60ec63-6473-4895-b322-e71ec64bfa6c"));


		options.setCapability("sauce:options", sauceOptions);
		options.setCapability("name","TESTSS");
		
		URL url = new URL("https://oauth-ahmed.3bdelstar-6ae3e:ff60ec63-6473-4895-b322-e71ec64bfa6c@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

		RemoteWebDriver   driver = new RemoteWebDriver(url, options);



	driver.get("http://197.168.1.22/login");
		

		//driver.findElement(By.className("")).sendKeys("GAEB@gmail.com");
		driver.findElement(By.xpath("//input[@formcontrolname='Email']")).sendKeys("GAEB@gmail.com");

		//driver.findElement(By.className("")).sendKeys("Gaeb@123456\r\n");
		driver.findElement(By.xpath("//input[@formcontrolname='Password']")).sendKeys("Gaeb@123456");

		//	driver.findElement(By.className("btn btn-primary")).click();
		//	driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
}
