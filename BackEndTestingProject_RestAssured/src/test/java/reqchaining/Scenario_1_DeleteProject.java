package reqchaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pojoclass.utility.ProjectPojo;

public class Scenario_1_DeleteProject {
	

	@Test
	public void postDataToServer() {
		
    //attach Random num to get unique project name every time
		//create an object to pojo class
		
		Random random = new Random();
		int ranNum = random.nextInt(5000);	
		
//Scenario=>1 delete project (for dlt ,we should Add the project 1st);
//API -->01 Add a project in side server
	    ProjectPojo pobj= new ProjectPojo("RCB_Bangalore"+ranNum, "Created", "tss", 0);
	
	  Response resp = given()
	    		                 .contentType(ContentType.JSON)
	    		                 .body(pobj)
	                       .when()
	                             .post("http://49.249.29.4:8091/addProject");
	          resp.then()
	                      .assertThat().statusCode(201)
	                      .log().all();  //display full  response
	          
	          //Capture Project id form the response & Using that Delete the project ;
	          //here,to capture projectID i am using restAssured json path because it is not a complex path or 
	          //dynamic so (i am not using JsonPath Class)
	          
	          String projectID = resp.jsonPath().get("projectId");
	          System.out.println(projectID);
	          
	        //API==> 02 Delete Project using projectID(req chaining concept);
	            given()
	                    .delete("http://49.249.29.4:8091/project/"+projectID)
	                    .then().log().all();
	            System.out.println("Successfully Deleted Project");
	            
	            //this tc never get fail because its creating unique project every time and deleting it
	            
	          
	          
	          
}
	

}
