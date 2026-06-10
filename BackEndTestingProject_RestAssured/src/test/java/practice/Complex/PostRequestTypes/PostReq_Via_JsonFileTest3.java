package practice.Complex.PostRequestTypes;


import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReq_Via_JsonFileTest3 {
	
	@Test
	public void postDataToServer() {
		File fileObj = new File("./data/project.json");
		
		given()
		        .contentType(ContentType.JSON)
		        .body(fileObj)
		.when()
		        .post("http://49.249.29.4:8091/addProject")
		.then()
		        .assertThat().statusCode(201)
		        .log().all();
	}
	
}
