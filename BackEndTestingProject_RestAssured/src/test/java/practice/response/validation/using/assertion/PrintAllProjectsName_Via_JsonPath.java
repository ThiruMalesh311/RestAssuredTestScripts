package practice.response.validation.using.assertion;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PrintAllProjectsName_Via_JsonPath {

	@Test
	public void sampleTest() {
	
	         Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
	         
	         resp.then().log().all();
	         
	         //write json xpath using that u should print all project names 
	     //   ArrayList<String> lst = resp.jsonPath().get("content[*].projectId");//this is ERROR
	         
	         // "*"using * is not allowed in restassured jsonPath to 8 we should add a dependency "JSON Path" we should
	         //add this dependency here regular expression is allowed and we can give conditions also
	         
	         ArrayList<String> lst = resp.jsonPath().get("content.projectId");
	         System.out.println(lst);
	         ArrayList<String> Pname = resp.jsonPath().get("content.projectName");
	            System.out.println(Pname);
	      	         
	}
}