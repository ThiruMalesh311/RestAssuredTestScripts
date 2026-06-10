package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForCompleteUpdateTest {
	
	@Test
	public void putDataToServer() {
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "tss");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "RCB_Bangalore");
		
	 given()
	          .contentType(ContentType.JSON)
	          .body(jsonObj.toJSONString())
	 .when()
	         .put("http://49.249.29.4:8091/project/NH_PROJ_381")
	 .then()
	         .assertThat().statusCode(200)
	         .log().all();
     
	 
	 System.out.println("Successfully updated { Completelly }  Project");
		
	}
}
