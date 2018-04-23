package com.alayam.core;

class SexException extends Exception{

	
	
}
public class MetOveride extends MetOverload {
	
	
	@Override
	 public void print()
	    {
	    	System.out.println("In Overide");
	    }
		 static void setSex(String sex) throws SexException
		{
			if(!sex.equals("MALE") || !sex.equals("FEMALE") ){
				throw new SexException();
			}
				
		}
		
		public static void main(){
			try{
			setSex("xyz");
			
			}catch (SexException e){
				e.printStackTrace();
			}
			
		}
}
  