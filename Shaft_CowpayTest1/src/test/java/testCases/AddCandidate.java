package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;

public class AddCandidate extends LoginTest {


	public AddCandidate() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void AddCandidateData() {

		By Name=By.xpath("//input[contains(@name, 'name')]");
		By Email=By.xpath("//input[contains(@formcontrolname, 'Email')]");
		By Phone=By.xpath("//input[contains(@name, 'Mobile')]");
		WebElement countryID=driver.findElement(By.xpath("//input[contains(@formcontrolname, 'CountryId')]"));
		WebElement cityID=driver.findElement(By.xpath("//input[contains(@formcontrolname, 'CityId')]"));
		By Address=By.xpath("//input[contains(@name, 'Address')]");
		By OptionalAddress=By.xpath("//input[contains(@name, 'OptionalAddress')]");
		By AddnewLink=By.xpath("//a[contains(text(), 'Add New Social Link')]");

		WebElement Type=driver.findElement(By.xpath("//select[contains(@name, 'type')]"));
		WebElement linkurl=driver.findElement(By.xpath("//input[contains(@name, 'URL')]"));

		//	By AddLink=By.xpath("//div[@class='modal-footer']/button[contains(@type,'button')and contains(text(),'Add')][1]");
		By AddLink=By.cssSelector("button[class='btn-profile btn-primary')]");
		By CancelLink=By.cssSelector("button[class='btn-profile btn-secondary')]");
		//div[contains(@class,'modal-footer')]//button[contains(text(),'Add')]
		//#ModalSocial > div > div > div.modal-footer > button.btn-profile.btn-primary

		By NationalID=By.xpath("//input[@name='NationalId']");
		By CommercialRegistrationNum=By.xpath("//input[contains(@name,'CommercialRegistrationNum')]");
		By CommercialRegistrationImages=By.xpath("//input[contains(@formcontrolname,'CommercialRegistrationImages')]");
		By TaxId=By.xpath("//input[contains(@name,'TaxId')]");
		By TaxIdImages=By.xpath("//input[contains(@formcontrolname,'TaxIdImages')]");
		By MainAdd=By.xpath("//div[contains(@class,'right-side')]//button[contains(text(),'Add')]");
		By MainCancel=By.xpath("//div[contains(@class,'right-side')]//a[contains(text(),'Cancel')]");


	//	Select Country=new Select(countryID);
	//	Country.selectByIndex(1);

	//	Select City=new Select(countryID);
	//	City.selectByIndex(1);

	//	Select Typeclick=new Select(Type);
	//	Typeclick.selectByIndex(1);

	//	Select linkurlclick=new Select(linkurl);
	//	linkurlclick.selectByIndex(1);
		
		
		ExcelFileManager excelreader=new ExcelFileManager(System.getProperty("testDataFolderPath")+"Extractor Data.xlsx");
		
		ElementActions.type(driver, Name, excelreader.getCellData("Name"));
		ElementActions.type(driver, Phone, excelreader.getCellData("Phone"));

	ElementActions.type(driver, Email, excelreader.getCellData("Email"));
	Select Country=new Select(countryID);
	Country.selectByIndex(1);
	
	Select City=new Select(countryID);
	City.selectByIndex(1);
		
		ElementActions.type(driver, Address, excelreader.getCellData("Address"));
		ElementActions.type(driver, OptionalAddress, excelreader.getCellData("OptionalAddress"));
		ElementActions.click(driver, AddnewLink);
		Select Typeclick=new Select(Type);
		Typeclick.selectByIndex(1);
		Select linkurlclick=new Select(linkurl);
		linkurlclick.selectByIndex(1);
		
		ElementActions.click(driver, AddLink);
		ElementActions.type(driver, NationalID, excelreader.getCellData("NationalID"));
		ElementActions.type(driver, NationalID, excelreader.getCellData("CommercialRegistrationNum"));
		ElementActions.type(driver, TaxId, excelreader.getCellData("TaxId"));
		ElementActions.click(driver, MainAdd);
		
		
	
	
	
	
	}

}
