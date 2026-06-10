package practice;

import org.testng.annotations.Test;

import com.backend.testing.MethodChaining_A;


public class Runner2 {
	//method chaining ,earliyer we create obj of particular class and we access the methods of that particular class but 
    //Using method chaining create object of class a and access all methods of that particular class and as well as other class methods also
	
	@Test
	public void sampleTest() {
		MethodChaining_A a1=new MethodChaining_A();
		a1.a().b().c().d();//other class object d mtd also we can access with out creating object of class B
		
		//if that methods are static we can access directly using Static import 
	}
	
}
