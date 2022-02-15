package Learning.RestAssured2;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Resrtclass1 {
	
	
	
	

	
	
  @Test
  public void Test1() {
	  
	  
	  given()
	  	.get("https://reqres.in/api/users?page=2")
	  		.then()
	  			.assertThat().statusCode(200)
	  
	  				.and()
	  				
	  					.assertThat().body("data[0].'email'", equalTo("michael.lawson@reqres.in"));
	  
  }
  
  
  
  
  
  
  
  

	@Test

	public void restTest1() {

		given().

			get("https://reqres.in/api/users?page=2")

				.then()

					.assertThat().statusCode(200).and()

					.assertThat().body("data[0].'email'",equalTo("michael.lawson@reqres.in"));

	}





	@Test
	public void restTest2Statuscode() {

		Response respon1=RestAssured.get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(respon1.getStatusCode(), 200);


	}

	@Test
	public void restTest3containsdata() {

		String respon1=RestAssured.get("https://reqres.in/api/users?page=2").andReturn().asString();

		Assert.assertTrue(respon1.contains("contributions towards server costs are appreciated!"));


	}

	@Test
	public void getPageData() {

		String respons2=RestAssured.get("https://reqres.in/api/users?page=2").andReturn().asString();

		System.out.println(respons2);

	}

  
}
