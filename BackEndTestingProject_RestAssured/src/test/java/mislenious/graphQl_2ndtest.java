package mislenious;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class graphQl_2ndtest {
	
	@Test
	public void addProject_graphQlTest() {
		
		  String   query = "mutation { addProject( projectName: \"Project Name\", teamSize: 5, createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		
		given()
		       .contentType(ContentType.JSON)
		       .body(query)
		  .when()
		       .post("http://49.249.29.4:8091/addProject-graphql")
		    .then()
		    .log().all();
		       
		       
	}

}
