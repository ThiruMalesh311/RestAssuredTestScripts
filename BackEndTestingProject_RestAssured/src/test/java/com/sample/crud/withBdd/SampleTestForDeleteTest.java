package com.sample.crud.withBdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestForDeleteTest {
	
	@Test
	    public void DeleteDataFromServer() {
		
		given()
		        .delete("http://49.249.29.4:8091/project/NH_PROJ_381")
	   .then()
	           .assertThat().statusCode(204)
	           .log().all();
		
		System.out.println("Successfully Deleted Mumbai Indians team from Server");
	 
		  
	}

}
