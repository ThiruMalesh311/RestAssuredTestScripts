package data_driven_testing_DDT;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddMultipleProjectsUsingExcel {
	
	
	@Test(dataProvider = "getData")
    public void createProjectTest(String projectName, String status) {

        String reqbody = "{\r\n"
                + "  \"createdBy\": \"Tss\",\r\n"
                + "  \"projectName\": \"" + projectName + "\",\r\n"
                + "  \"status\": \"" + status + "\",\r\n"
                + "  \"teamSize\": 0\r\n"
                + "}";

        given()
            .contentType(ContentType.JSON)
            .body(reqbody)
        .when()
            .post("http://49.249.29.4:8091/addProject")
        .then()
            .statusCode(201)
            .assertThat()
            .contentType(ContentType.JSON)
            .body("projectName", Matchers.equalTo(projectName))
            .body("status", Matchers.equalTo(status))
            .log().all();
    }

    @DataProvider
    public Object[][] getData() throws Throwable {
    	ExcelUtility elib=new ExcelUtility();
    	int count = elib.getRowCount("Project");
    	
         Object[][] objr = new Object[count][2];
         
          for(int i=0 ; i<count ;i++) 
           {
        	   objr[i][0] = elib.getDataFromExcel("Project", i+1, 0);
        	   objr[i][1] = elib.getDataFromExcel("Project", i+1, 1);
          }
         return objr;
         }
  }
