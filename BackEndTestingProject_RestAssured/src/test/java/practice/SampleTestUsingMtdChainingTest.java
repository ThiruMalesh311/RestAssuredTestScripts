package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestUsingMtdChainingTest {
	
	@Test
	public void getRequestTest() {
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.prettyPrint());
	}

}
