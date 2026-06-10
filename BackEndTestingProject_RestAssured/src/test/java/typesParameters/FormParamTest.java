package typesParameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FormParamTest {
	
	//formParam should use with Post because in get we dont have body so
	@Test
	public void sampleTest() {
		
           given()
                 .formParam("teamSize", 0)//data get hided and in resp body it will display 
                 .log().all()//it displays req Header and body
           .when()
                  .post("http://49.249.29.4:8091/project")
           .then()
           .log().all();//it displays Response header and body
	
	}

}
