package com.alayam.algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class part{	
	char moveDir_;
	int pos_;

	part(char moveDir, int pos){
		moveDir_ = moveDir;
		pos_ = pos;
	}
}

public class Particle {
	static ArrayList <part> partlist_ = new ArrayList<part>();
	static int arraylen;


	public static String[] animate(int speed, String init){
		String result[] = new String[init.length()];
		char[] charArray = init.toCharArray();
		arraylen = init.length();

		//Populate with initial position
		for(int i=0; i<init.length(); ++i){
			if(charArray[i] != '.'){
				part p = new part(charArray[i], i);			
				partlist_.add(p);
			}
		}
		
		int j=0;
		while(!partlist_.isEmpty()){			
			result[j++] = printList();
			moveNext(speed);
			//updateList();
		}
		result[j++] = printList();
		return  Arrays.copyOf(result, j);
	}
	
	public static void updateList(){
		Iterator<part> iter = partlist_.iterator();
		while(iter.hasNext()){
			part p = iter.next();
			if(p.pos_ <0 || p.pos_ >= arraylen){
				iter.remove();
			}
		}
	}

	public static void moveNext(int speed){
		Iterator<part> iter = partlist_.iterator();
		while(iter.hasNext()){
			part p = iter.next();
			
			if(p.moveDir_ == 'L')
				p.pos_ = p.pos_ - speed;
			else if (p.moveDir_ == 'R')
				p.pos_ = p.pos_ + speed;
			
			if(p.pos_ <0 || p.pos_ >= arraylen){
				iter.remove();
			}
		}
		
		/*
		  for(part p1: partlist_){
		
			if(p1.moveDir_ == 'L')
				p1.pos_ = p1.pos_ - speed;
			else if (p1.moveDir_ == 'R')
				p1.pos_ = p1.pos_ + speed;
		}
	
	*/
	}

	public static String printList(){
		char[] tempArray = new char[arraylen];
		Arrays.fill(tempArray, '.');
		for(part p1: partlist_){
			tempArray[p1.pos_] = 'X'; 
		}
//		for(int i=0; i<tempArray.length; i++){
//			System.out.print(tempArray[i]);
//		}				
//		System.out.println("");

		return new String (tempArray);
	}
	public static void main(String args[]){

		String inStr[] = {"..R....",
				"RR..LRL",
				"LRLR.LRLR",
				"RLRLRLRLRL",
				"...",
				"LRRL.LR.LRR.R.LRRL."};
		int speed[] ={2,3,2,10,1,1};

		for(int i=0; i<inStr.length; i++){
			System.out.println("----------------------------");
			System.out.println("speed "+speed[i] + "str "+inStr[i]);
			String res[] = Particle.animate(speed[i], inStr[i]);
			for(String s: res){
				System.out.println(s);
			}
		}
	}
}