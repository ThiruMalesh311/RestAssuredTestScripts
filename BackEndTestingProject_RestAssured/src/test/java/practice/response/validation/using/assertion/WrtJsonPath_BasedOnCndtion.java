package practice.response.validation.using.assertion;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class WrtJsonPath_BasedOnCndtion {
	
	@Test
	public void sampleTest() {
		
		Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
        resp.then().log().all();
        
        //here we added json path dependency so using class "JsonPath" we can write complex json path it accepts 2 arguments
       //1st argument we should paste "resp" object(it should be converted into string ) ,2nd we should write json path any complex path we can give here
        //this "JSonPath" navigate to resp body and based on jsonxpath it give result/response;
        List<String> list = JsonPath.read(resp.asString(), ".content[*].projectName");
        System.out.println(list);
        
        //we can use for loop to display all project names 
       for(String data: list) {
    	   System.out.println(data);
     }
       
       List<String> list1 = JsonPath.read(resp.asString(), ".content[*].[?(@.projectName=='ABB_461')].projectId");
       System.out.println(list1.get(0));//here based on ProjectId give Project Name of that id ; we gave projectName and checking whether we get particular projectid or Not;
       //here i gave ProjectName and fecting project Id of its
       
       //here i can validate using testng assertion 
       
          String actProjectId = list1.get(0);
          
          Assert.assertEquals(actProjectId, "NH_PROJ_024");
          
        
        
	}

}
