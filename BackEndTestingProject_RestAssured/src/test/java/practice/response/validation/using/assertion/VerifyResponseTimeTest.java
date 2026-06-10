package practice.response.validation.using.assertion;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {
	
	@Test
	public void verifyHeader() {
		
		 Response resp = given().get("http://49.249.29.4:8091/projects");
		 
		 resp.then().log().all();
		 
		 //Print time taken to execute program
		 long timeTaken = resp.time();//by default milliSec
		 long timeTakenInSec = resp.timeIn(TimeUnit.SECONDS);
		 long timeTakenInMilliSec = resp.timeIn(TimeUnit.MILLISECONDS);
		 
		 System.out.println(timeTaken);
		 System.out.println(timeTakenInSec);
		 System.out.println(timeTakenInMilliSec);
		 
		 //validate time taken to give response 
		 
		 //if we wanto get response less than 900 MilliSec
		 resp.then().assertThat().time(Matchers.lessThan(900L));
		
		 //here we using lesser than greater than () Present inside "MATCHERS"class to validate time we can't use equal to () here 
		 //beacuse each time we execute the response time will be different so we always use lessthan greater than present in Matchers(c)
		 
		 resp.then().assertThat().time(Matchers.greaterThan(300l));
		 
		 //matchers class present in hamcrest Package 
		 
		 resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900l)).and(Matchers.greaterThan(300l)));
				
		
	}

}
