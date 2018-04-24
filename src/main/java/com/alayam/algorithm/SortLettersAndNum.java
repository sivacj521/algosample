package com.alayam.algorithm;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;


public class SortLettersAndNum {

	public static void sort(String init){
		
		List<Integer> numSet = new ArrayList<Integer>();
		List<String> strSet = new ArrayList<String>();

		
		Pattern pSpace = Pattern.compile("\\s");
		String[] items = pSpace.split(init);
		char[] pos = new char[1000];
		
		int j=0;
		for(String s : items) {
			try{
				Integer int1 = Integer.parseInt(s);
				numSet.add(int1);
				pos[j++] = 'I';
			}catch(NumberFormatException e){
					strSet.add(s);
					pos[j++] = 'N';
			}
		}
		
		Collections.sort(numSet);
		Collections.sort(strSet);
		
		//Print the array
		Iterator<Integer> numIter = numSet.iterator();
		Iterator<String> strIter = strSet.iterator();
	
		for(int i=0; i<j; i++) {
			
			if(pos[i] == 'I'){				
				System.out.print(numIter.next());
			}else{
				System.out.print(strIter.next());
			}
			if( i !=j -1)
				System.out.print(" ");
		}
		System.out.println("");
	}



	

	public static void test(String args[]){

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));

		try {
			SortLettersAndNum.sort(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		String inStr[] = {
				"8 4 8 6 1 -2 9 5",
				"car truck 8 4 bus 6 1",
		""};		

		for(String s: inStr){
			System.out.println("================================");
			System.out.println(s);
			SortLettersAndNum.sort(s);			
		}
	}
}
