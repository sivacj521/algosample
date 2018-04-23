package com.alayam.core;
import java.util.BitSet;


public class TestEnum {	
	enum TestHeight{
		small,
		medium,
		tall,
		too_tall;
	}
	
	public static void main(String args[]){
		System.out.println("Before setting " + Integer.MAX_VALUE);
		BitSet b = new BitSet(Integer.MAX_VALUE);
		b.set(Integer.MAX_VALUE -10);
		System.out.println("size " + b.length());
//		boolean b[] = new boolean[2000000000];
//		for(int i=0; i<b.length ;i++){
//			b[i] = false;
//			
//		}
		System.out.println("After setting");
	}

}
  