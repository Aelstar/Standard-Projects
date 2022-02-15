package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import basic.Config.SetUp;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Rest2Test extends SetUp {

	public Rest2Test() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	@Test
	public void Reset_HeaderContent() {
		
		
		Response response2=
				RestAssured.get(prop.getProperty("API"));
		
	System.out.println(	response2.getBody().asString());
	System.out.println(	response2.getHeader("content-type"));
	System.out.println(response2.getContentType());
	System.out.println(response2.getStatusLine());
	System.out.println(response2.getTime());
		
	}
	
	
	@Test
	public void get_alllog() {
		
	//RestAssured.baseURI= "";
				given().get(prop.getProperty("API")).then().body("data[2].id", equalTo(8)).log().all();
	}
	
	@Test
	public void test_Post() {
		
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("name", "value");
		given().post("https://reqres.in/api/users").then().statusCode(201);
	}
	
	
	@Test
	public void test_Put() {
		
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("first_name", "value");
		given().put("https://reqres.in/api/users/2").then().assertThat().statusCode(200);
		
		
	}
	
	
	
}
