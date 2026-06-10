package mislenious;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GraphQl_6thTest {
	
	@Test
	public void getProjectByProjectIdTest() {

		String query = " { findProject(projectId:\"NH_PROJ_***\"){ projectId projectName status createdBy teamSize } }";
		given()
		.contentType(ContentType.JSON)
		.body(query)
		
		.when()
				.post("http://49.249.29.4:8091/getProjectByProjectId")
	   .then()
	   .log().all();

	}

}
