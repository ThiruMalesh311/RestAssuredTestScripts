package practice.Complex.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Vai_HashMapTest {
	
	//in previous class i created object to Json here insted of json obj i am creating Object of HashMap ;

	@Test
	public void postDataToServer() {
		 
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("createdBy", "ts");
		map.put("status", "Created");
		map.put("teamSize", 0);
		map.put("projectName", "RCB4");
		
		//Pre-Condition
	     given()
	           .contentType(ContentType.JSON)
               .body(map)	           
	    .when()
	          .post("http://49.249.29.4:8091/addProject")       
	    .then() //validation i use then
	          .assertThat().statusCode(201)
	          .log().all();
	  
	  System.out.println("Successfully Added/Created  New Project");
		
	}

}
