package com.alayam.core;

public class Card {
	
	private String color;
	private String suite; //Spade, Diamond, Clover,Hearts
	private int value; // 2-10,J,Q,K,A ...... 1(A)-10,J(11),Q(12),K(13)
	
	
	
	
	Card(int value, String suite){
		this.value = value;
		this.suite = suite;
		//Deciede on the suite to assign color
		if(suite.equals("SPADE") || 
				suite.equals("CLOVER") ){
			this.color = "BLACK";
		}else{
			this.color = "RED";
		}		
	}
	
	void display(){
		System.out.println("Card info "+ value +":" + color + ":" + suite);
	}

}
