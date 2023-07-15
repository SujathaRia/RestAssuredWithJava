package restAPI;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void test1() {

		
		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/11");

		System.out.println("Response code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
	}
}
