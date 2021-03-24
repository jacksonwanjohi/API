package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class POST_Or_Create_A_Product {
//	SoftAssert sofAssert = new SoftAssert();

	@Test
	public void create_A_Product() {
//		https://techfios.com/api-prod/api/product/create.php
		HashMap payload = new HashMap();
		payload.put("name", "Hp Envy Laptop");
		payload.put("description", "one of the best laptops in th market for an amazing price");
		payload.put("price", "750");
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
					.body(payload)
				.when()
					.post("/create.php")
				.then()
					.extract().response();
		
		String responseBody = response.asString();
		System.out.println("ResponseBody: " + responseBody);
		
		 // Passing responseBody to JSON 
		 JsonPath js = new JsonPath(responseBody);
		 String message = js.getString("message");
		 
		 Assert.assertEquals(message, "Product was created.");
		
		
	
		 
		 
		 
		 
		  //Assertion of a product 
//		  String productID = js.getString("id"); 
//		  String productName = js.getString("name"); 
//		  String productDescription =js.getString("description"); 
//		  Assert.assertEquals(productID , "1209");
//		  Assert.assertEquals( productName , "HP Laptop Elite Pro");
//		  Assert.assertEquals(productDescription , "Super fast laptop");
		  
	
//		System.out.println(productID );
//		js.prettyPrint();
		
//		  int statusCode = response.getStatusCode(); 
//		  System.out.println("Status code:" + statusCode); Assert.assertEquals(statusCode, 200); 
////	  Soft Assert
//		  sofAssert.assertEquals(statusCode, 200); 
//		  
//		  String responseBody = response.asString(); 
//		  response.prettyPrint(); 
//		  System.out.println(response);
//		  
//		  
//		  long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		  System.out.println("Response Time: " + responseTime);
//		  
//		  if (responseTime <= 3000) {
//		  System.out.println("Response Time is within the range"); 
//		  } else {
//		  System.out.println("Response Time Not Acceptable !!"); }
	 
		 


	}

}
