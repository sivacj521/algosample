package com.alayam.core;

import java.util.ArrayList;
import java.util.List;


public class Deck {

	List<Card> _cardsList = new ArrayList<Card>();
	
	Deck(){		
	}

	public void create()
	{
		//create full suit 
		// Repeat step1. 4 times.
		//1. creating 13cards
		
		//At the end create step 2
		//2. creating 2 joker
		System.out.println("Creating a DECK");
		for(int i =1; i<=13; i++)
		{			
			_cardsList.add(new Card(i,"SPADE"));
			//System.out.print(i);
			_cardsList.add(new Card(i,"CLOVER"));
			//System.out.print(i);
			_cardsList.add(new Card(i,"DIAMOND"));
			//System.out.print(i);
			_cardsList.add(new Card(i,"HEARTS"));
			//System.out.print(i+"");
		}
		
		for(int i =1; i<=2; i++)
		{
			_cardsList.add(new Card(0,"JOKER"));
		}
		
	}
	
	public void display()
	{
		for(int i =0; i<=_cardsList.size(); i++){
			Card c = (Card)_cardsList.get(i);
			c.display() ;			
		}
	}
}
