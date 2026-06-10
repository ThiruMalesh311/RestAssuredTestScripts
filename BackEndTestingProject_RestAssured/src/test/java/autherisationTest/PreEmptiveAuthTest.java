package autherisationTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PreEmptiveAuthTest {

	@Test
	public void sampleTest() {
		//ninza-HRM does not support basic auth ,So use NinzaPay
		
		
		    given()//pre-condition we give here
		    
		    .auth().preemptive().basic("rmgyantra", "rmgy@9999")//using basic auth
		    .log().all()//display log in info of Request
		    
		    .when()//is for execution
		        .get("http://49.249.29.5:8091/login")
		           
		    .then()//then() is for validation
		    .log().all();//display log info of Response
	}
}
