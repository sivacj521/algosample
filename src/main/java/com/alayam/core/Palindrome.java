package com.alayam.core;

public class Palindrome {

	static char[] reverse(char[] str, int length){
		int l= length-1;
		int startPt=0;		
		char text[];
		text =new char[length];

		for(int i=l; i>=0; i--)
		{
			text[startPt]=str[i];
			//System.out.println("Inserting : "+ text[startPt]);
			startPt++;

		}		
		
		for(int j=0;j<=l;j++)
		{
			System.out.print( text[j]);	
		}
		
		return text;

	}

	boolean isPalindrome(char[] str, int length){
		char[] revStr = reverse(str, length);
		for(int i=0; i< length ; i++)
		{
			if(revStr[i] != str[i])			
			{
				System.out.println("  Its not palindrome");
				return false;
			}
		
		}
		System.out.println("String is Palindrome");		
		return true;
	}
	
	public static void main(String args[]){
		String str = args[0];
		str.toCharArray();
		System.out.println(args[0]);
		
		reverse(str.toCharArray(),str.length());
	}
	
	
	
	
	public static void main1(String args[])
	{
		String s="hand";
		//int startPt=0;
		int endPt=s.length()-1;
		char text[]=new char[s.length()];
		
		//StringBuilder sr=new StringBuilder(s);
		
		
		//if(startPt<endPt)
		for(int j=0;j<s.length();j++)
		{
		for(int i=0;i<=endPt;i++)
		//while(startPt<=endPt)
		{
			int d=endPt-i;
			//String p=s.substring(d);
			char p=s.charAt(d);
			text[i]=p;
			
			//sr.append(p);
			//System.out.println("The string is :" +p);
			//endPt--;
		//System.out.println("The string is :" +text[i]);
		}
		
		System.out.println("The string using j :" +text[j]);
		}
		
		
		
		//System.out.println("Using Stringbuilder:"+sr);
		//System.out.println("Using Reverse fn:"+sr.reverse());

	}
	
}
