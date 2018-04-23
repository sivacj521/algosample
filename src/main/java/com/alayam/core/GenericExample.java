package com.alayam.core;

public class GenericExample {

	public static void main(String args[]){
		Box<String> b = new Box<>();
		Integer t = new Integer(10);
		String str1 = "av";
		b.set(str1);
		//Integer str =  b.get();
		
		Box<String> b1 = new Box<>();
		Box<Integer> b2 = new Box<>();
		Box<Integer> b3 = new Box<>();
	}
}
