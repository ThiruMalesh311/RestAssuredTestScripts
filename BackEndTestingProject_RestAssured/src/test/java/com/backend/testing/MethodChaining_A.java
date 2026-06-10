package com.backend.testing;

public class MethodChaining_A{

	//this class act as parent because i am using this class methods in runner2 class
	
	public MethodChaining_A a() {
		System.out.println("execute mtd a");
		return new MethodChaining_A();
	}
	
	public MethodChaining_A b() {
		System.out.println("execute mtd b");
		return new MethodChaining_A();
		
	}
	public MethodChaining_B c() {
		System.out.println("execute mtd c");
		return new MethodChaining_B();
	}
}
