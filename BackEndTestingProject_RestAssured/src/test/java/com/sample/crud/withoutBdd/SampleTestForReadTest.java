package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {
	//readTest means Get Request
	@Test
	public void getDataFromServer() {
		Response resp = RestAssured.get("http://49.249.29.4:8091/projects");
		
		//System.out.println(resp.prettyPrint());//prettyPint method formate response into Json formate
		
		//to put basic validation(to validate data) in response obj we have method then()
		
		resp.then().assertThat().statusCode(200);
		
		//log.all()=>this method is going to display complete information of response Headder & Body;
		resp.then().log().all();
	}

}
