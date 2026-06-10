package autherisationTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerTokenAuthTest {
	//here in niza HRM==>Settings-->Dev Settings==>generateToken using that token accessing projects
	//this is not auth2.0 these is using berertoken i am accessing resource;
	
	@Test
	public void sampleTest() {
		
		    given()//pre-condition we give here
		    
		    .auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3ODAzODU5MDIsImlhdCI6MTc4MDM4NDE4NiwianRpIjoiNjJiM2VhZTAtNzI0MC00OGViLWI3ZTUtNTIzNzk5OTI1OGRmIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgwL2F1dGgvcmVhbG1zL25pbnphIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjQ4NWVhMmFiLWRjYzMtNDA4Yi05NTFmLTg0YzAzYmZkMDAyZiIsInR5cCI6IkJlYXJlciIsImF6cCI6Im5pbnphLWNsaWVudCIsInNlc3Npb25fc3RhdGUiOiJlZjBjYzgyNy0yNjFiLTQ2YTEtOGEzYi1lMmY0MGYyNGI1YTUiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHA6Ly80OS4yNDkuMjguMjE4OjgwOTEiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbmluemEiLCJvZmZsaW5lX2FjY2VzcyIsImFkbWluIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJlZjBjYzgyNy0yNjFiLTQ2YTEtOGEzYi1lMmY0MGYyNGI1YTUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InJtZ3lhbnRyYSJ9.EIpoi4GE7LWIhx1-pVUB0wyXLRj_pJysgxC_OJDFc2OYsgjkGFBLaAJL_VkcOa_YkzQhRTeszAkanIBqmHNwVhCOuV6YHFJ8mWwkEjpjFOkNhtlcINGoyCkwOA94er4-AE_Gnf2evpIFTSMtZDtwzD0tUFiY4YVUFNzsv92EXzZ2p6DYefAKIVZtWoeyJs-x9oJ_gx0-kmjuNpPUJB8wcms92fjppG28l6Da1jQaVjBN3cbQwwnquzLJkmLf3lydc24QZRFONZwMVJh7Zj6kyUldLNpejJclYa3L-ZcPYD5TDnhP9zPlJFHDkYUMDZTH29F8COQ4C8oNTHnqE6JbKA")
		    .log().all()//display log in info of Request
		    
		    .when()//is for execution
		        .get("http://49.249.29.4:8091/projects")
		           
		    .then()//then() is for validation
		    .log().all();//display log info of Response
	}
	
}
