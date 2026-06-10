package com.sample.crud.withBdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTestForReadTest {
	
	//here we performing crud operations using Bdd
	//1st we do Static import and then since it is get() not have pre conditions we can directly execute and validate response
	@Test
	public void getDataFromServer() {
		
                 given()
	                    .get("http://49.249.29.4:8091/projects")
	            .then()
	                    .assertThat().statusCode(200)
	                    .log().all();
		
	}

}
