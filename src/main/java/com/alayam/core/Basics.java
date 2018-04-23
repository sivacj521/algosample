package com.alayam.core;

public class Basics {
	//pass by value or ref	
	public static void increment(String val){
		 
	}
	
	public static void main(String args[]){
		//int x = 10;
//		Integer x = new Integer(10);
//		Basics.increment(x);
//		//int temp = x.intValue();
//		//Basics.increment(temp);
//		System.out.println("Value "+x);
//		
		
		JayaInt y = new JayaInt(10);
	
		y.increment();
		System.out.println("value "+ y);
		
	}
	
	
}

class JayaInt{
	int value;
	
	public JayaInt(int i){
	 value =i;
	}
	
	void increment(){
		value++;
	}
	
	public String toString(){
		String str = "";
		str = str + value;
		return str;
		//return Integer.toString(value);
	}
}