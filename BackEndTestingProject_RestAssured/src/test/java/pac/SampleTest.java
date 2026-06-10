package pac;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;

public class SampleTest {
	@Test
	public void sampleGetReqTest() {
		
		//RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();//using method chaining its executes all
		//if we do static import no need to give restassured name also"(get("https://reqres.in/api/users?page=2").prettyPrint();) 
		//.prettyPrint();==> only give response payload 
		
		
		//if we want to use other methods of rest assured 
 		get("https://reqres.in/api/users?page=2")
 		.then()
 		.log()
 		.all();//if use this we will get Headder and Body of response(complete log info);
		
		//Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		//System.out.println(resp.prettyPrint());
	}

}
