package com.alayam.core;

class TestPrivate {
  void fun()
  {
     System.out.println("Base fun");
  }
}
 
class Derived extends TestPrivate {
   void fun()
   {
	 
     System.out.println("Derived fun");	
     System.out.println("");
     
     //super.fun();
     
  }
  public static void main(String[] args) {
     TestPrivate obj = new Derived();
      obj.fun();
  }
}