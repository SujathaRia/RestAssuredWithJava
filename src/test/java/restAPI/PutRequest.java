package restAPI;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	public void test1() {

		HashMap<String, Object> requestBody = new HashMap<String, Object>();
		requestBody.put("name", "John");
		requestBody.put("salary", "10000");

		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(requestBody)
				.put("/7");

		String body = response.getBody().asString();
		System.out.println("Response body is " + body);

		System.out.println("Response code is " + response.statusCode());
	}

}
