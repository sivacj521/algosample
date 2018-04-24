package com.alayam.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class CopyOfSortLettersAndNum {

	public static void sort(String init){
		
		SortedSet<Integer> numSet = new TreeSet<Integer>();
		SortedSet<String> strSet = new TreeSet<String>();

		
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



	public static void sort1(String init){

		SortedSet<Integer> numSet = new TreeSet<Integer>();
		SortedSet<String> strSet = new TreeSet<String>();

		Pattern pSpace = Pattern.compile("\\s");
		Pattern pNum = Pattern.compile("\\d");
		String[] items = pSpace.split(init);
		for(String s : items) {
			//System.out.println(s);	            
			Matcher m = pNum.matcher(s);
			boolean b = m.matches();
			if(b){
				numSet.add(Integer.parseInt(s));
			}else{
				strSet.add(s);
			}
		}

		//Print the array
		Iterator<Integer> numIter = numSet.iterator();
		Iterator<String> strIter = strSet.iterator();

		for(String s : items) {
			Matcher m = pNum.matcher(s);
			boolean b = m.matches();
			if(b){
				System.out.print(" "+numIter.next());
			}else{
				System.out.print(" "+strIter.next());
			}
		}
		System.out.println("");
	}

	public static void test(String args[]){

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));

		try {
			CopyOfSortLettersAndNum.sort(br.readLine());
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
			CopyOfSortLettersAndNum.sort(s);			
		}
	}
}
