package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
	
	@Test
	public void DeleteDataFromTheServer() {
		
		Response resp = RestAssured.delete("http://49.249.29.4:8091/project/NH_PROJ_375");
		
		resp.then()
		           .log().all();
		resp.then()
		           .statusCode(204);
	}

}
