package mislenious;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GraphQL_QueryExecution4th {
	
	@Test
	public void sampleTest() {
		
		  String   query = "{ getAllProjects{ projectId projectName status } }";
		
		given()
		       .contentType(ContentType.JSON)
		       .body(query)
		  .when()
		       .post("http://49.249.29.4:8091/getAll")
		    .then()
		    .log().all();
		       
		       
	}
	
	@Test
	public void getParticularTest() {
		
		  String   query = "{ getAllProjects{ projectId status } }";
		
		given()
		       .contentType(ContentType.JSON)
		       .body(query)
		  .when()
		       .post("http://49.249.29.4:8091/getAll")
		    .then()
		    .log().all();
		       
		       
	}
	
	

}
