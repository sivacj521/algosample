package com.alayam.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingLetters {
	private static byte AtoZ[] = new byte[26];

	//Code is not Re-entrant.
	public static String getMissingLetters(String inStr){		
		//Reset the array
		for(int i=0; i<AtoZ.length;++i){
			AtoZ[i]=0;
		}

		//Mark the chars
		for(int i=0; i<inStr.length();++i){
			int iChar = (int)inStr.charAt(i);

			if(iChar >=97 && iChar <=122){
				//Code for lower case
				int pos = iChar - 97; //index in array
				AtoZ[pos] = 1;
			}else if(iChar >=65 && iChar <=90){
				//Code for upper case
				int pos = iChar - 65; //index in array
				AtoZ[pos] = 1;
			}
		}

		//Collect the missing chars
		StringBuffer result = new StringBuffer("");
		for(int i=0; i<AtoZ.length;i++){
			if(AtoZ[i]== 0){
				result = result.append((char)(i + 97));
			}
		}
		return result.toString();
	}

	public static void main(String args[]){
		String inStr[] = {"The quick brown fox jumps over a lazy dog",
				"A slow yellow fox crawls under the proactive dog",
				"Lions, and tigers, and bears, oh my!",
		""};

		for(int i=0;i<inStr.length;++i)
			System.out.println("Hello Missing words \"" + MissingLetters.getMissingLetters(inStr[i])+"\"");


//		BufferedReader br =
//				new BufferedReader(new InputStreamReader(System.in));
//
//		String input;
//
//		try {
//			while((input=br.readLine())!=null){
//				System.out.println(input);
//				System.out.println("Hello Missing words \"" + MissingLetters.getMissingLetters(input)+"\"");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}


}
