package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_Or_Read_A_Product {
	SoftAssert sofAssert = new SoftAssert();

	@Test
	public void read_A_Product() {
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json;")
					.queryParam("id", "1389")
				.when()
					.get("read_one.php")
				.then()
					.extract().response();
		
		String responseBody = response.getBody().asString();
		
		//Passing responseBody to JSON
//		JsonPath js = new JsonPath(responseBody);	
//		String productID = js.getString("id");
//		String productName = js.getString("name");
//		String productDescription = js.getString("description");
//		sofAssert.assertEquals(productID , QueryIdValue);
//		sofAssert.assertEquals( productName , "HP Laptop Elite Pro");
//		sofAssert.assertEquals(productDescription , "Super fast laptop");
		
//		sofAssert.assertAll();
		
	}

}
