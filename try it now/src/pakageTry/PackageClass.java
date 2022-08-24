package pakageTry;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PackageClass {



	@SuppressWarnings("deprecation")
	public static void main(String[]args) {

		System.setProperty("webdriver.chrome.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
		;


		//System.setProperty("webdriver.gecko.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\geckodriver-v0.29.0-win32\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();


		driver.get("http://197.168.1.22/login");

		//driver.findElement(By.className("")).sendKeys("GAEB@gmail.com");
		driver.findElement(By.xpath("//input[@formcontrolname='Email']")).sendKeys("GAEB@gmail.com");

		//driver.findElement(By.className("")).sendKeys("Gaeb@123456\r\n");
		driver.findElement(By.xpath("//input[@formcontrolname='Password']")).sendKeys("Gaeb@123456");

		//	driver.findElement(By.className("btn btn-primary")).click();
		//	driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement dd=	driver.findElement(By.cssSelector("button[type='submit']"));

		dd.clear();
		Select ww=new Select(dd);

		ww.selectByIndex(0);

		// 	"(//tagname[@attribute='value'])[2]"
		
		//  "//tagname[contains(@attribute,'value')]"
		
		//  "//tagname[text()='value']"
		
		//  "//*[contains(text(), 'value')]"

		System.out.println("done"+"\t"+"done");

		Actions action =new Actions(driver);
		action.click().build().perform();
		action.sendKeys(Keys.ARROW_DOWN).contextClick();

		
		
		Set<String> id= driver.getWindowHandles();
		Iterator <String>it=id.iterator();
		String child=	it.next();

		driver.switchTo().window(child);
		action.contextClick().build().perform();

		

		WebDriverWait wait=new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(dd));

		wait.until(ExpectedConditions.invisibilityOfAllElements(dd));

		action.sendKeys(Keys.TAB);


		driver.switchTo().frame(20);
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		

		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		WebDriverWait waits =new WebDriverWait(driver, 30);
		waits.until(ExpectedConditions.elementSelectionStateToBe(dd, false));

		//""//tagname[@attrubite='value']"

		//tagname[attrubite='value']"
		
		

		driver.findElement(By.cssSelector(child));

		action.clickAndHold(dd).moveToElement(dd).release();


		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollHntoView(true);", dd);
		js.executeScript("arguments[0].click();", dd);
		js.executeScript("argiments[0].setAttribute('value','"+"15-5-2021"+"')", dd);	//fore set date مكان dd


		driver.findElement(new ByAll(By.className("dddd"), By.id("ccc")));
		driver.findElement(new ByChained(By.id("ccc"), By.className("cc")));
		driver.findElement(new ByIdOrName("name or id"));

		
		
		driver.get("https://www.google.com/");
		WebElement goog=driver.findElement(By.name("q"));
		goog.sendKeys("android");
		
		System.out.println(driver.findElements(By.className("OBMEnb")).size());




	}

	
}
