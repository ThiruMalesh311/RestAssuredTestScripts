package practice.Complex.PostRequestTypes;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojoclass.utility.ProjectPojo;

public class PostReq_Vai_PojoClassTest4 {

	
	@Test
	public void postDataToServer() {
		
    //attach Random num to get unique project name every time
		Random random = new Random();
		int ranNum = random.nextInt(5000);
		
	//Create an object to pojo class
	
	ProjectPojo pobj= new ProjectPojo("RCB_Bangalore1"+ranNum, "Created", "Deepak", 0);
	
	given()
	        .contentType(ContentType.JSON)
	        .body(pobj)
	.when()
	        .post("http://49.249.29.4:8091/addProject")
	 .then()
	         .assertThat().statusCode(201)
	         .log().all();
}
	
}
