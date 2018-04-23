package com.alayam.core;

import java.util.Collection;
import java.util.Enumeration;

public class TestCore {
	
	public void varArgsTest(String ... strArgs){
		
		System.out.println("args length "+strArgs.length);
	}

	public void varArgsTest(String first, String ... strArgs){
				
		System.out.println("String args "+strArgs[0]+" 1:"+strArgs[1] );		
	}
	
	public static void main(String args[]){
		TestCore test = new TestCore();
		TestCore test1 = new TestCoreChild();
		//test.varArgsTest("hello");
		test.varArgsTest();
		
		//fo.find(test1.getClass());
		//test.varArgsTest("hello","how","are", 10 );
		//test.varArgsTest(10, "hello","how","are");
		//test.varArgsTest("hello");
	}
		
}
