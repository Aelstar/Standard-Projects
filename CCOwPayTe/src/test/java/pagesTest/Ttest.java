package pagesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;


public class Ttest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub



		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsIn\\chromedriver.exe");

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriver 	driver=new ChromeDriver(option);

		driver.get("http://197.168.1.222:7070/");
		
		
Thread.sleep(3000);

		WebElement UserName =driver.findElement(By.xpath("//input[@data-val-required='Username is required']"));
		WebElement Password=driver.findElement(By.id("Password"));
		WebElement LoginButton=driver.findElement(By.className("login-btn"));
		
		UserName.sendKeys("tttt");
		Password.sendKeys("test");
		LoginButton.click();





	}

}
