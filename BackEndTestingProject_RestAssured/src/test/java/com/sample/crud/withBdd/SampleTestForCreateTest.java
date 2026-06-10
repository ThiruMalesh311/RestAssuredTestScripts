package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForCreateTest {
	
	@Test
	public void postDataToServer() {
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "ts");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "RCB2");
		
		//Pre-Condition
	     given()
	           .contentType(ContentType.JSON)
	           .body(jsonObj.toJSONString())
	           
	    .when() //perform (Http)Post Request
	    
	           .post("http://49.249.29.4:8091/addProject")       
	           
	    .then() //validation i use then
	    
	           .assertThat().statusCode(201)
	           .log().all();
	  
	  System.out.println("Successfully Added/Created  New Project");
		
	}

}
