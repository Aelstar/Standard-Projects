package pagesTest;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import configrations.BaseTest;


public class TaxPage108Test extends BaseTest{

	public TaxPage108Test() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean acceptNextAlert = true;


	//	private boolean isElementPresent(By by) {
	//		try {
	//			driver.findElement(by);
	//			return true;
	//		} catch (NoSuchElementException e) {
	//			return false;
	//		
	//			
	//		}
	//	}



	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}}

	@Test
	public void get_Tax() throws InterruptedException {




		String word_temp="\u0627\u0644\u0641\u0631\u0633\u0627\u0646";
		try {
			word_temp = new String(word_temp.getBytes("UTF-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(word_temp);





		driver.navigate().to("http://197.168.1.248/etataxgateEF/");

		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-login']"));
		login.click();

		Thread.sleep(3000);
		WebElement loginmail=driver.findElement(By.id("userNameInput"));
		WebElement passwordbutt=driver.findElement(By.id("userPwdInput"));

		loginmail.sendKeys("excel8");
		passwordbutt.sendKeys("P@ssw0rd");

		WebElement loginaction=driver.findElement(By.id("btnSubmitLogin"));
		loginaction.click();

		Thread.sleep(3000);

		WebElement IncomeLink=driver.findElement(By.xpath("//li[@id='IncomeLink']"));

		IncomeLink.click();
		Thread.sleep(3000);

		WebElement IncomeLink1=driver.findElement(By.xpath("//li[@id='IncomeLink']/ul[@class='dropdown-menu']/li[1]/a[@role='button']"));

		IncomeLink1.click();
		Thread.sleep(3000);



		WebElement IncomeLink108=driver.findElement(By.xpath("//li[@id='IncomeLink']/ul[@class='dropdown-menu']/li[1]/ul[@class='dropdown-menu']//a[@href='/etataxgateEF/IncomeTaxDeclarations/IncomeTax_108']"));

		IncomeLink108.click();

		Thread.sleep(3000);


		WebElement selectyear=driver.findElement(By.xpath("//select[@id='sanna']"));

		Select selctyall=new Select(selectyear);

		selctyall.selectByValue("2021");


		WebElement continbutton=driver.findElement(By.xpath("//button[@id='ToDeclaration108']"));
		continbutton.click();

		Thread.sleep(8000);



		WebElement contin2=driver.findElement(By.xpath("//input[@id='checkboxes']"));
		contin2.click();


		Thread.sleep(8000);

		WebElement centerrepo1=driver.findElement(By.xpath("//div[@id='navigation']/ul//a[@id='step2']"));
		centerrepo1.click();
		Thread.sleep(8000);

		List <WebElement> labelss=driver.findElements(By.tagName("label"));

		List <WebElement> elementss=driver.findElements(By.tagName("input"));

		System.out.println("Label Size is: "+labelss.size());

		System.out.println("Element Size is: "+elementss.size());




		for(WebElement element : elementss) {

			//		for(WebElement label : labelss) {
			//	System.out.println("text of label is: "+label.getAttribute("innerHTML").toString());



			String  Nameoflocator=element.getAttribute("name");
			System.err.println(Nameoflocator);





			//String halfxpathh="//input[@name='"+Nameoflocator+"']";
			//	System.out.println("half of variable xpath issss/../"+halfxpathh);


			//	List<WebElement> labelNameNedded=driver.findElements(By.xpath(halfxpathh+"/ancestor::span/parent::div/child::label[1]"));
			//	System.out.println(labelNameNedded);


			//	if(labelNameNedded.size()!=0) {

			//	WebElement labelNamegeted=driver.findElement(By.xpath(halfxpathh+"/ancestor::span/parent::div/child::label[1]"));
			//	System.out.println(labelNamegeted);


			//System.out.println("text of label is: "+labelNameNedded.getAttribute("innerHTML").toString());

//*****************
			String halfxpathh="//input[@name='"+Nameoflocator+"']";
		List<	WebElement> labelNamegeted=driver.findElements(By.xpath(halfxpathh+"/ancestor::span/parent::div/child::label[1]"));
			if (labelNamegeted.size()!=0) {
			System.out.println(labelNamegeted.get(0).getAttribute("innerHTML").toString());

//***************
			
			//System.out.println("The name of label is: "+labelNamegeted.getAttribute("innerHTML").toString());	
			
			System.out.println("Name for Attribute is: "+element.getAttribute("name"));
			System.out.println("the Name of placeholder is: "+element.getAttribute("placeholder"));

			System.out.println("Next label....\n");



				}





						else{
			
							System.err.println(" label not found");
						}


		}







		WebElement logout=driver.findElement(By.xpath("//button[@id='dropdownMenu1']/p[@class='username-text']"));
		logout.click();

		WebElement logoutaction=driver.findElement(By.xpath("//div[@id='AccountLink']/ul[@class='dropdown-menu']//a[@href='/etataxgateEF/Account/Logout']"));
		logoutaction.click();

	}




}
