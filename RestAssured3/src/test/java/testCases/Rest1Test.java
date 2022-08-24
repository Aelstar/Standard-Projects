package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import basic.Config.SetUp;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import testPages.Rest1Page;
import testUtils.ExcelData;

public class Rest1Test extends SetUp{

	public Rest1Test() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Rest1Page restpage;
	
@When("check Status")
	@Test
	public void check_Status() {
		
		
		given().get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().statusCode(300);
		
		System.out.println("check status code************");
	}


	@When("check Datajson")
	@Test
	public void check_Datajson() {
		
		String respons=given().get(prop.getProperty("API")).andReturn().asString();
		
		Assert.assertTrue(respons.contains("contributions towards server costs are appreciated!"));
		
		
		
		System.out.println("check data **********");
	}
	
	@When("check data2")
	@Test
	public void check_data2() {
		given()
		.get(prop.getProperty("API"))
		.then().assertThat()
		.body("data[0].'email'", equalTo("michael.lawson@reqres.in"));
		
	
		
	}
	
@When("get Page Data")
	@Test
	public void getPageData() {

		String respons2=RestAssured.get(prop.getProperty("API")).andReturn().asString();

		System.out.println(respons2);

	}

@When ("rest Test2 Status code")
	@Test
	public void restTest2Statuscode() {

		Response respon1=RestAssured.get(prop.getProperty("API"));

		Assert.assertEquals(respon1.getStatusCode(), 200);


	}
	
	@When("test all rest")
	@Test(dataProvider="Provider")
	public void test_all_rest(String emil3) {
		
		given().get(prop.getProperty("API")).then()
		.assertThat().body("data[3].'email'",equalTo(emil3))
		.and()
		.assertThat().statusCode(200);
		
		
	}
	
	
	@When ("getTitle")
	@Test
	public void getTitle() throws IOException {
		
		 restpage=new Rest1Page();
		 
		 restpage.get_Title(); 
	}
	
	@When ("getURL")
	@Test
	public void getURL() {
		
		restpage.get_URL();
		
	}
	
	@DataProvider
	public Object[][] Provider() throws IOException {
		
		Object[][]data=ExcelData.get_Data("Sheet1");
		return data;
	}
	
}
