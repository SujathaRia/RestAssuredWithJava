package GitHub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {
	
	@Test
	
	public void test1() throws IOException {
		
		
		byte[] datafile = Files.readAllBytes(Paths.get("repoData.json"));
		
		RestAssured.baseURI = "https://api.github.com/user/repos";

		RequestSpecification request = RestAssured.given();

		Response response = request.auth().oauth2("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")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(datafile).post();

		String body = response.getBody().asString();
		System.out.println("Response body is " + body);

		System.out.println("Response code is " + response.statusCode());
		Assert.assertEquals(response.statusCode(), 201);
	}

}
