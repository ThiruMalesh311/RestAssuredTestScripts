package encryption;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class APIEncodeTest {
	
	@Test
	public void sampleTest() {
		
		given()
		     .auth().preemptive().basic("rmgyantra", "rmgy@9999")//here using preemptive auth we encoding un and psw but it convert to ascii values any body if they get to know that values they ca easily hack or Decode un and psw so
		                    // in real time we go for digestive auth "because in digestive auth Autherization data only not visible in header so"
		.when()
		     .get("http://49.249.29.4:8091/projects")
		.then()
		     .log().all();
		
	}

}
