package autherisationTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2_0_Test2 {
	

	@Test
	public void sampleTest() {
		
		//API = 01 to hit client_app to generate token sending req to clientapp
		Response resp =  given()
                .formParam("client_id", "ninza-client")
	            .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
	            .formParam("grant_type", "client_credentials")
		  .when()
		        .get("http://49.249.29.4:8091/auth/realms/ninza/protocol/openid-connect/token");
		  resp.then()
		        .log().all();
		   
		   //after getting response capture token from response client app (gives token )using that response(tokenID)we access resource or application
		  
		   //API= 2 capture token from the response [keyClock]Outh 2.0
		   String token = resp.jsonPath().get("access_token");
		   
		       given()
		           .auth().oauth2(token)
		           .log().all()
		       .when()
		           .get("http://49.249.29.4:8091/projects")
		       .then()
		           .log().all();
		   	}
 }
