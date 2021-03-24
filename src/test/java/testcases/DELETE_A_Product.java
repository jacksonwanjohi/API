package testcases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DELETE_A_Product {
	
	GET_Or_Read_A_Product readProduct = new GET_Or_Read_A_Product();
	
	SoftAssert sofAssert = new SoftAssert();
	
	@Test
	public void delete_A_Product() {
//		https://techfios.com/api-prod/api/product/delete.php	
		
		HashMap payload = new HashMap();
		payload.put("id", "1389");
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
					.body(payload)
				.when()
					.delete("/delete.php")
				.then()
					.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody: " + responseBody);
		
		 // Passing responseBody to JSON 
		 JsonPath js = new JsonPath(responseBody);
		 
		 String message = js.getString("message");
		 
		 //sofAssert.assertEquals(message, "Product was Deleted.");

		 
		 sofAssert.assertAll();
		
	
	}

}
