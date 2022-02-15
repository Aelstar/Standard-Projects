package pagesTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseConfig.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssured1 extends Config{

	public RestAssured1() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Test

	public void restTest1() {
System.out.println("test assured 1");
		given().

			get(prop.getProperty("API1"))

				.then()

					.assertThat().statusCode(200).and()

					.assertThat().body("data[0].'email'",equalTo("michael.lawson@reqres.in"));

	}





	@Test
	public void restTest2Statuscode() {
		System.out.println("test assured 2");
		Response respon1=RestAssured.get(prop.getProperty("API1"));

		Assert.assertEquals(respon1.getStatusCode(), 200);


	}

	@Test
	public void restTest3containsdata() {
		System.out.println("test assured 3");
		String respon1=RestAssured.get("https://reqres.in/api/users?page=2").andReturn().asString();

		Assert.assertTrue(respon1.contains("contributions towards server costs are appreciated!"));


	}

	@Test
	public void getjsonPageData() {
		System.out.println("test assured 4");
	
		String respons2=RestAssured.get("https://reqres.in/api/users?page=2").andReturn().asString();

		System.out.println(respons2);

	}

}
