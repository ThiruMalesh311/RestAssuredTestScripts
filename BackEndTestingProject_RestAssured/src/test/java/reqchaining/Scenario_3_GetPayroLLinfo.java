package reqchaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Scenario_3_GetPayroLLinfo {
	//using token we should get payroll info (swagger doc ->payRollController->admin/payrolls(we get all payroll-info here)
	//Login to App via Api 01 And get auth token ,then get an payroll info vai API-2;
	
	@Test
	public void sampleTest() {
		
		//API-1 get Auth API-1 :(authentication Api)goTo=SwaggerDoc-->authentication-controller-->POST;
		Response resp = given()
		  
		         .formParam("client_id", "ninza-client")
		         .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		         .formParam("grant_type", "client_credentials")
		         
		  .when()//B/f sending req we should pass some info regarding to authetication (the info is given by developer)we should pass that
		         .post("http://49.249.29.4:8180/auth/realms/ninza/protocol/openid-connect/token");//b/f executing this give some pre conditions
		          resp.then().log().all();
		         
		//Capture the token from response 
		          String token = resp.jsonPath().get("access_token");
		          System.out.println("==="+token+"===");
		
		//API-2 get payroll info
		          
		given().contentType(ContentType.JSON)
		      .auth().oauth2(token)
		      .get("http://49.249.29.4:8180/admin/payrolls")//b/f this we should pass token 
		.then()
		     .log().all();
		
	}
	
}
