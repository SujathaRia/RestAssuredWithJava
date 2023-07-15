package RestAPIBDD;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestBDD {
	
	@Test
	public void test1() {
		
		RestAssured.given()
				.baseUri("http://localhost:3000/employees")
				.when()
				.get()
				.then()
				.log()
				.body()
				.statusCode(200)
				.body("[3].name", Matchers.equalTo("John"));
			
	}

	@Test
	public void test2() {
		
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get("/4")
		.then()
		.log()
		.body() //or everything() or all() can be used 
		.statusCode(200)
		.body("name", Matchers.equalTo("James"));
		
	}
	
	@Test
	public void test3() {
		
		Response response = RestAssured.given()
				.baseUri("http://localhost:3000/employees")
				.when()
				.get();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
}
