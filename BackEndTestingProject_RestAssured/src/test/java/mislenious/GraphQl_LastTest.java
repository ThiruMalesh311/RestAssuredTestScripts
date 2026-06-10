package mislenious;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GraphQl_LastTest {
	
	@Test
	public void updateProjectTest() {
		
		  String   query = "mutation { updateProject( projectId: \"NH_PROJ_113\" projectName: \"Mumbai Indians\", teamSize: 0, createdBy: \"smile\", createdOn: \"2026-08-24\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		
		given()
		       .contentType(ContentType.JSON)
		       .body(query)
		  .when()
		       .post("http://49.249.29.4:8091/updateProject-graphql")
		    .then()
		    .log().all();
		       
		       
	}

}
