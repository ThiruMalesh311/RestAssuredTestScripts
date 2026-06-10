package practice;

import org.testng.annotations.Test;

import static com.backend.testing.StaticImport_A.*;

public class Run1 {
	
	@Test
	public void sampleTest() {
		given();
		when();
		then();
//without using class name we accessing static methods directly because we used Static import;
	}

}
