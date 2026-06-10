package typesParameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameterTest {
	
	@Test
	public void sampleTest() {
		
           given()
                 .queryParam("teamSize", 0)
           .when()
                  .get("http://49.249.29.4:8091/project")
           .then()
           .log().all();
	
	}

}

