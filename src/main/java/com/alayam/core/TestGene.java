package com.alayam.core;

public class TestGene {
	public static void main(String args[])
	{
		System.out.println(Max("jaya","siva","tanvi"));
		System.out.println(Max(20,55,67));
	}



public static <T extends Comparable<T>> T Max(T a,T b, T c)
{
	T max=a;
	if(b.compareTo(a)>0)
	
		max=b;
	
	if(max.compareTo(c)>0)
	
		max=c;
	
		
	return c;
	
}
}

