package testcases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUT_Or_Update_A_Product {
	
	GET_Or_Read_A_Product readProduct = new GET_Or_Read_A_Product();
	
	
	SoftAssert sofAssert = new SoftAssert();

	@Test
	public void update_A_Product() {
//		https://techfios.com/api-prod/api/product/update.php		  
		HashMap payload = new HashMap();
		payload.put("id", "1316");
		payload.put("name", "Samsung Galaxy Note 20");
		payload.put("description", "Amazing Android Phone");
		payload.put("price", "1200");
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
					.body(payload)
				.when()
					.put("/update.php")
				.then()
					.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody: " + responseBody);
		
		 // Passing responseBody to JSON 
		 JsonPath js = new JsonPath(responseBody);
		 String message = js.getString("message");
		 
		 sofAssert.assertEquals(message, "Product was Updated.", "Not Matching the assertions");
		 
		 //Read A product from the GET or Read A Product Class
		 readProduct.read_A_Product("1316");
		 
		 sofAssert.assertAll();
		

	}

}
