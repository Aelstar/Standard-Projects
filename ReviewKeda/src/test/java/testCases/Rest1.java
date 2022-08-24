package testCases;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import basics.Configs;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Rest1 extends Configs{
	
	
	
	public Rest1() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public void RestTest1() {
		
		given().get(prop.getProperty("APILink")).then().assertThat().statusCode(200);
		
		
	}
	@Test
	public void RestTest2() {
		
		String response=given().get(prop.getProperty("APILink")).andReturn().asString();
		Assert.assertTrue(response.contains("o keep ReqRes free, contributions towards server costs"));
		System.out.println(response);
	}
	@Test
	public void RestTest3() {
		
		
		given().get().then().assertThat().body("data[0].'email'", equalTo("michael.lawson@reqres.in"));
		
	}

	@Test
	public void RestTest4() {
		

		Response respon1=RestAssured.get(prop.getProperty("API"));

		Assert.assertEquals(respon1.getStatusCode(), 200);
		
	}
}
