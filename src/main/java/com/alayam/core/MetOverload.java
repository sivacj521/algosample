package com.alayam.core;

import java.util.Collection;
import java.util.HashSet;

public class MetOverload {
	
		  
	    public static void main(String args[])  {
	       Collection c = new HashSet();
	       MetOverload et = new MetOverload();
	       et.sort(c);
	       MetOverload mo=new MetOveride();
	       mo.print();
	       
	      
	    }
	   
	    //overloaded method takes Collection argument
	    public Collection sort(Collection c){
	        System.out.println("Inside Collection sort method");
	        return c;
	    }
	  
	   
	   //another overloaded method which takes HashSet argument which is sub class
	    public Collection sort(HashSet hs){
	        System.out.println("Inside HashSet sort method");
	        return hs;
	    }
	      
	    
	    public void print()
	    {
	    	System.out.println("In Overload");
	    }
	}


	
