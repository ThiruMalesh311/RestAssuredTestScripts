package reqchaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployePOJO;
import pojoclass.utility.ProjectPojo;

public class Scenario_2_AddEmployeToProject {
	
	//add emp to project scenario ,so before adding emp Project should be created 
	
	@Test
	public void postDataToServer() {
		
		Random random = new Random();
		int ranNum = random.nextInt(5000);	
		
	//Api =>01 add a project in side Server
	     ProjectPojo pobj= new ProjectPojo("RCB_Bangalore"+ranNum, "Created", "tss", 0);
	
	     Response resp = given()
	    		                 .contentType(ContentType.JSON)
	    		                 .body(pobj)
	                       .when()
	                             .post("http://49.249.29.4:8091/addProject");
	          resp.then()
	                      .assertThat().statusCode(201)
	                      .log().all(); 
	          String projectNAME = resp.jsonPath().get("projectName");
	          System.out.println(projectNAME);
	      
	       //Api =>02 Add employee to Same Project 
	             //to add emp take help of swagger doc in that we have module "employee-controller"(post: /employees)
	            // we have body so create pojo cls for that 1st
	            //to generate pojo class we can use online tool "Online POJO Class Generator";
	          
	          //Create empPojo cls object
	         EmployePOJO empObj=new EmployePOJO("TestEngineer", "27/11/1998", "tss@gmail.com", "user_"+ranNum, 18, "8884554620", projectNAME, "ROLE_EMPLOYEE", "user_"+ranNum);
	            //here i am using reqChaining concept for "projectName" & "role" Capture frm "Scema Validation" in SwaggerDOC(->models->employee->projectrole select any one");
	                        
	                    given().contentType(ContentType.JSON).body(empObj)
	                    
	                       .when()
                               .post("http://49.249.29.4:8091/employees")
	                       .then()
	                             .assertThat().statusCode(201)
	                             .log().all();
	}
}
