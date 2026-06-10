package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForPartialUpdateTest {
	
	
	@Test
	public void PatchDataToServer() {
		
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("projectName", "Mumbai_Indians");
		
		given()
		       .contentType(ContentType.JSON)
		       .body(jsonObj.toJSONString())
		.when()
		       .patch("http://49.249.29.4:8091/project/NH_PROJ_381")
		.then()
		       .log().all();
		
		System.out.println("Successfully changed team name form RCB to Mumbai Indians ");
		
	}

}
