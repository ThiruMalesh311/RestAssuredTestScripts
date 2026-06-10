package com.backend.testing;

public class StaticImport_A {
	
	//here i created 3 static methods  ,in another package if i wanto use this method i should call it by using class name 
	//but here i make use of static import and i make use of this methods directly in runner class1 (practice package)
	public static void given() {
		System.out.println("execute given mtd");
	}

	public static void when() {
		System.out.println("execute when mtd");
	}
	public static void then() {
		System.out.println("execute then mtd");
	}
}
