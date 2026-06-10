package practice.response.validation.using.assertion;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyDataComplexJsonPath {

	@Test
	public void sampleTest() {
		
		Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
        
       // resp.then().log().all();
        
        //here we added json path dependency so using class "JsonPath" we can write complex json path it accepts 2 arguments
        
        List<String> list = JsonPath.read(resp.asString(), ".content[*].projectName");
        
        //1st argument we should paste "resp" object(it should be converted into string ) ,2nd we should write json path any complex path we can give here
        //this "JSonPath" navigate to resp body and based on jsonxpath it give result/response;
        System.out.println(list);
        
        //we can use for loop to display all project names 
       for(String data: list) {
    	   System.out.println(data);
       }
        
        
        
	}
}
