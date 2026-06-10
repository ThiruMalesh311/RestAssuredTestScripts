package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {
	//while performing post operation we cant pass body directly we make use of "given()" and it will return "req specification "class obj
	//using this cls we specify "Pre-Condition" like =ContentType , req body  if req body is in json Ctype we should add json simple to pom.xml
	
	
	@Test
	public void postDataToServer() {
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "ts");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "RCB");
		
	 RequestSpecification req = RestAssured.given();
	 req.contentType(ContentType.JSON);
	 req.body(jsonObj.toJSONString());
	 
	 Response resp = req.post("http://49.249.29.4:8091/addProject");
     
	 resp.then().log().all();
	 resp.then().assertThat().statusCode(201);
	 
	 System.out.println("Successfully Added/Created  New Project");
		
		
		
		
		
	}

}
