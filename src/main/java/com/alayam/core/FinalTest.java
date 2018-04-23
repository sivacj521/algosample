package com.alayam.core;

import java.util.Hashtable;

public class FinalTest {
	
 static final int i;
	static{
		int n=1;
		//i=0;
		i=0+n+2;
		//i=n;
		
	}
	FinalTest()
	{
		//i=0;
	}
	
	public static void main(String args[]){
		Hashtable<String , Employee> _table = new Hashtable<String, Employee>();
		Employee emp1 = new Employee(1, "jaya", "durai");
		Employee emp2 = new Employee(1, "jaya", "durai");
		Employee emp3 = null;
		
		String str = "abc";
		//str.equals();
				
		
		if(emp1.equals(emp1)){
			System.out.println("They are equal");
		}else
		{
			System.out.println("They are Not equal");
		}
		
	}
	

}
