package practice.response.validation.using.assertion;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseHeaderTest {
	
	@Test
	public void verifyHeader() {
		
		//capture response obj and reuse this object for assertion / validayion of response
		Response resp = given()
		                    .get("http://49.249.29.4:8091/projects");		              
	
	        //using assertion validate/Verify response Headder
		     resp.then().log().all();
		
		     resp.then().assertThat().contentType(ContentType.JSON);
		     resp.then().assertThat().statusLine("HTTP/1.1 200 ");
		     resp.then().assertThat().statusCode(200);
		
		//here using headder () we trying to verify keys and value of app in response this may change if app change
		//so we get so many keys so we use headder () to validate key-value
		
		resp.then().assertThat().header("Transfer-Encoding", "chunked");
	    resp.then().assertThat().header("Connection", "keep-alive");
		
	}

}
