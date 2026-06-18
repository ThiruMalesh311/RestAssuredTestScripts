package practice.response.validation.using.assertion;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseBody_via_JsonPath {
	
	@Test
	public void sampleTest() {
	
		//here i want project name based on page so in swagger i selecting "projects-paginated"
	         Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
	         
	         resp.then().log().all();
	         
	         //Useing built Method of RestAssured to validate JSON response Body Response Using inbuilt assertion,
	         // here we not using testng assertion we are using restAssured  Assertion
	         
	         //body()=use restassured's (3rd method)using jsonPath and Matchers Class we validating respBody
	         //1st argument "JsonPath" (2nd argument "using Matchers class methods validate "value")
	         resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
	         
	         resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
	         
	         resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_569"));

	   //===========================================================================================================================
	         
	         
	         //To capture/extract data using json path use this
	        
	         //to write json path we have a method jsonpath() and inside that given()
	         // using that we write json path ,here we dont use . "dot" because while using 
	         //RESTAssured JsonPath() it will automatically put ."DOT " while writing json xpath we should put ."dot";
	         
	           int data1 = resp.jsonPath().get("numberOfElements");
	           System.out.println(data1); //here we capturing/extracting data from resp payload and displaying data
	           
	           // after this if we want validation we should use testNg assertion so instead of this directly use inbuilt RestAssured method for assertion
	         
                Boolean data2 = resp.jsonPath().get("pageable.sort.unsorted");
                System.out.println(data2);
                
                String data3 = resp.jsonPath().get("content[0].projectId");
                System.out.println(data3);//once extraction is done ,we can use testng assertion for validation or
                //best practice is to use restAssured Assertion method 
	}

}
