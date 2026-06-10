package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
		//here we updating or changing complete Name or completely changing something;
	//if we are updating completely means ,only then we should go for this put because it will modify completely
	//old data is replaced by new data 
	
		@Test
		public void putDataToServer() {
			
			JSONObject jsonObj = new JSONObject();
			
			jsonObj.put("createdBy", "ts");
			jsonObj.put("status", "Created");
			jsonObj.put("teamSize", 0);
			jsonObj.put("projectName", "RCB");
			
		 RequestSpecification req = RestAssured.given();
		 req.contentType(ContentType.JSON);
		 req.body(jsonObj.toJSONString());
		 
		 Response resp = req.put("http://49.249.29.4:8091/project/NH_PROJ_378");
	     
		 resp.then().log().all();
		// resp.then().assertThat().statusCode(200);
		 
		 System.out.println("Successfully updated { Completelly }  Project");
			
	}

	}

