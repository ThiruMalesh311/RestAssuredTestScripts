package typesParameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParamParameterTest2 {
	
	@Test
	public void sampleTest() {
		
           given()
                 .param("teamSize", 0)//param+GET REQ act like Query_Param = because data attached  along with URL (act Like "query_Parameter")
                 .log().all()//it displays "req_Header" and body
           .when()
                  .get("http://49.249.29.4:8091/project")
           .then()
           .log().all();//it displays Response header and body
	
	}

}
