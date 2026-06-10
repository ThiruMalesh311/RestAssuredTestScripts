package mislenious;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ShoppersStack_SSl_TslValidation {
	
	
	@Test
	public void ssl_tslTest() {
		
		JSONObject jobj= new JSONObject();
		jobj.put("city", "tmk");
		jobj.put("country", "india");
		jobj.put("email", "thirumalesh@gmail.com");
		jobj.put("firstName", "Thiru");
		jobj.put("gender", "MALE");
		jobj.put("lastName", "TS");
		jobj.put("password", "Thiru@123");
		jobj.put("phone", "8884524620");
		jobj.put("state", "Karnataka");
		jobj.put("zoneId", "ALPHA");
		
		given()
		        .relaxedHTTPSValidation()//uing this method handle ssltsl
		       .contentType(ContentType.JSON)
		       .body(jobj)
		.when()
		.post("https://www.shoppersstack.com/shopping/shoppers")
		.then()
		.log().all();
	}

}
