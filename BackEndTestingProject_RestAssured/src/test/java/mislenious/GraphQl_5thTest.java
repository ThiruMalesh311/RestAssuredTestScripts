package mislenious;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GraphQl_5thTest {

	@Test
	public void getEmployeesByProjectIdTest() {

		String query = "{ findEmployees(projectId:\"NH_PROJ_***\"){ empId empName mobileNo email dob experience username designation role project } }";

		given()
		.contentType(ContentType.JSON)
		.body(query)
		
		.when()
				.post("http://49.249.29.4:8091/getEmployeesByProjectId-graphql")
	   .then()
	   .log().all();

	}

}
