package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_Or_Read_All_Products {

	@Test
	public void read_All_Products() {
//https://techfios.com/api-prod/api/product/read.php
		Response response=
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
		.when()
			.get("read.php")
		.then()
			.extract().response();

		int statusCode= response.getStatusCode();
		System.out.println("This is the status code:" + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String responseBody =  response.asString();
		System.out.println();
		
	}
	
	
}
