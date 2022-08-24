package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import com.shaft.tools.io.ReportManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.ElementAttributeType;











@SuppressWarnings({ "removal", "deprecation" })
public class LoginTest {

	public static Properties prop;

	public static WebDriver driver;

	public static 	ChromeOptions option;

	public static	ExcelFileManager excelmanager;

	
	
	public LoginTest() throws IOException {


		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("testDataFolderPath")+"prop.properties");

		//"C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Shaft_CowpayTest1\\src\\test\\resources\\testDataFiles\\prop.properties");

		prop.load(fis);


	}


	
		@BeforeClass
		@Test
		public void initialBrowser () {

			excelmanager=new ExcelFileManager(System.getProperty("testDataFolderPath")+"Extractor Data.xlsx");



			driver=  DriverFactory.getDriver();

			BrowserActions.navigateToURL(driver,  prop.getProperty("URL1"),  prop.getProperty("URL"));


			option=new ChromeOptions();
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			option.addArguments("--incognito");
			


			By userNameButton=By.xpath("//input[contains(@name,'Username')]");
			By passwordButton=By.xpath("//input[contains(@name,'Password')]");
			By loginButton=By.xpath("//button[contains(@class,'login-btn')]");




			ElementActions.type(driver, userNameButton, excelmanager.getCellData("UserName"));
			ElementActions.type(driver, passwordButton, excelmanager.getCellData("Password"));
			ElementActions.click(driver, loginButton);




		}
		@SuppressWarnings({ "deprecation", "removal" })
		@Test(priority=2)
		public void checklogindone() {

			By notificationsbutton=By.id("alertsDropdown");
			By element1Notification=By.xpath("//h6[contains(text(),'Your money transfer to mobile walat 01023456789 is pending')]");

			By merchamntButton=By.xpath("//span[contains(text(),'Merchants')]");

			By Hamburg=By.xpath("//div[contains(@class,'hamburger' )]");

			ElementActions.click(driver, notificationsbutton);
			ElementActions.click(driver, element1Notification);
			ElementActions.click(driver, Hamburg);
			ElementActions.click(driver, merchamntButton);

			//Verifications.verifyElementMatches(driver, merchamntButton, "Merchantbutton is displayed");
			Assertions.assertElementAttribute(driver, merchamntButton, ElementAttributeType.TEXT, "Merchants");


		}




		@Test(priority=1)
		public void testshaftworking() {


			ReportManager.log("test login cowpay*****");
		}


		
		
		@Test(priority=3)
		public void AddNewCandidate() {
			
			
			By AddNewCandidate=By.xpath("//div[@class='right-side']/a[contains(.,'Add New candidate' )and contains(@class,'btn web')]");
			
			ElementActions.click(driver, AddNewCandidate);
			
			
		}
		
		
		
		
		
		@Test
		public void AddCandidateData() {

			//driver.switchTo().frame(1);
		//	driver.switchTo().parentFrame();
			
		//	By Name=By.xpath("//input[contains(@name, 'name')]");
			By Name=By.xpath("//section[@class='validate-form']//div[@class='wrap-input']//input[@name='name']");
//			By Email=By.xpath("//input[contains(@formcontrolname, 'Email')]");
//			By Phone=By.xpath("//input[contains(@name, 'Mobile')]");
//		//	WebElement countryID=driver.findElement(By.cssSelector("body > app-root > div > div > app-add-new-merchant > div > form > div.container > div > div:nth-child(1) > section > div.row.mb-0 > div:nth-child(3) > div > select"));
//			//select[contains(@formcontrolname,'CountryId')]
//		//	WebElement cityID=driver.findElement(By.cssSelector("div:nth-of-type(4) > .wrap-input > .has-val.input.ng-invalid.ng-pristine.ng-touched"));
//			By Address=By.xpath("//input[contains(@name, 'Address')]");
//			By OptionalAddress=By.xpath("//input[contains(@name, 'OptionalAddress')]");
//			By AddnewLink=By.xpath("//a[contains(text(), 'Add New Social Link')]");
//
//		//	WebElement Type=driver.findElement(By.xpath("//select[contains(@name, 'type')]"));
//		//	WebElement linkurl=driver.findElement(By.xpath("//input[contains(@name, 'URL')]"));
//
//			//	By AddLink=By.xpath("//div[@class='modal-footer']/button[contains(@type,'button')and contains(text(),'Add')][1]");
//			By AddLink=By.cssSelector("button[class='btn-profile btn-primary')]");
//			By CancelLink=By.cssSelector("button[class='btn-profile btn-secondary')]");
//			//div[contains(@class,'modal-footer')]//button[contains(text(),'Add')]
//			//#ModalSocial > div > div > div.modal-footer > button.btn-profile.btn-primary
//
//			By NationalID=By.xpath("//input[@name='NationalId']");
//			By CommercialRegistrationNum=By.xpath("//input[contains(@name,'CommercialRegistrationNum')]");
//			By CommercialRegistrationImages=By.xpath("//input[contains(@formcontrolname,'CommercialRegistrationImages')]");
//			By TaxId=By.xpath("//input[contains(@name,'TaxId')]");
//			By TaxIdImages=By.xpath("//input[contains(@formcontrolname,'TaxIdImages')]");
//			By MainAdd=By.xpath("//div[contains(@class,'right-side')]//button[contains(text(),'Add')]");
//			By MainCancel=By.xpath("//div[contains(@class,'right-side')]//a[contains(text(),'Cancel')]");
//
//
////		Select Country=new Select(countryID);
////			Country.selectByIndex(1);
////
////			Select City=new Select(countryID);
////			City.selectByIndex(1);
////
////			Select Typeclick=new Select(Type);
////			Typeclick.selectByIndex(1);
////
////			Select linkurlclick=new Select(linkurl);
////			linkurlclick.selectByIndex(1);
////			
//			
			ExcelFileManager excelreader=new ExcelFileManager(System.getProperty("testDataFolderPath")+"Extractor Data.xlsx");
			
			
			ElementActions.type(driver, Name, excelreader.getCellData("Name"));
	//		ElementActions.type(driver, Phone, excelreader.getCellData("Phone"));

	//	ElementActions.type(driver, Email, excelreader.getCellData("Email"));
//		Select Country=new Select(countryID);
//		Country.selectByIndex(1);
//		
//		Select City=new Select(countryID);
//		City.selectByIndex(1);
//			
//			ElementActions.type(driver, Address, excelreader.getCellData("Address"));
//			ElementActions.type(driver, OptionalAddress, excelreader.getCellData("OptionalAddress"));
//			ElementActions.click(driver, AddnewLink);
//			
		//	Select Typeclick=new Select(Type);
		//	Typeclick.selectByIndex(1);
		//	Select linkurlclick=new Select(linkurl);
			//linkurlclick.selectByIndex(1);
//			
//			ElementActions.click(driver, AddLink);
//			ElementActions.type(driver, NationalID, excelreader.getCellData("NationalID"));
//			ElementActions.type(driver, NationalID, excelreader.getCellData("CommercialRegistrationNum"));
//			ElementActions.type(driver, TaxId, excelreader.getCellData("TaxId"));
//			ElementActions.click(driver, MainAdd);
//			
//			
//		
		
		
		
		}
		

	}
