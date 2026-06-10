package typesParameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParamParameterTest1 {
	
	@Test
	public void sampleTest() {
		
           given()
                 .param("teamSize", 0)//data get hided and in "resp body" it will display (act Like "Form_Parameter")
                 .log().all()//it displays "req_Header" and body
           .when()
                  .post("http://49.249.29.4:8091/project")
           .then()
           .log().all();//it displays Response header and body
	
	}


}
