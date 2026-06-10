package mislenious;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

import pojoclass.utility.ProjectPojo;

public class JsonSchemaValidation {
	
	@Test
	public void schemaTest() {
		
		ProjectPojo pobj=new ProjectPojo("rcb", "created", "tsss",0);
		
		Response resp = given()
		       .contentType(ContentType.JSON)
		       .body(pobj)
		.when()
		       .post("http://49.249.29.4:8091/addProject");
		 resp.then().log().all();
		 resp.then().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema.json")));
		  //we added dependancy json schema validator (io.restAssured) in this we have cls "jsonSchemaValidator"here we have matchesJsonSchema(in this give "schema validation file Path") and you should able to create project according to jsonschema "you should get 201";
		 
		
		
	}

}
