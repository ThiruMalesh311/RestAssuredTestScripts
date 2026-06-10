package typesParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void sampleTest() {
		
           given()
                  .pathParam("projectId", "NH_PROJ_015")
           .when()
                  .get("http://49.249.29.4:8091/project/{projectId}")//previosly we giving project id here in url ,
                                                               //but now on wards using path parameter we will specify Project id
           .then()
           .log().all();
	
	}

}
