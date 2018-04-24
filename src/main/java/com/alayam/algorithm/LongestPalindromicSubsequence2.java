package com.alayam.algorithm;

/**
 * Created by Tanvi on 9/3/2017.
 */
public class LongestPalindromicSubsequence2 {

    public int longestPalindrome(int n, String s){
        char [] chars = s.toCharArray();
        int [][]LP = new int[n][n];
        //LP[i][j] - length of palindrome from ith index to jth index
        // all the characters in the string are palindrome by itself of length 1.
        //So all LP[i][i] =  1
        for(int i=0;i<n;i++){
            LP[i][i] = 1;
        }

        for(int subLen = 2;subLen<=n;subLen++){
            for(int i=0;i<=LP.length-subLen;i++){
                int j = i+subLen-1;
                if(chars[i]==chars[j] && subLen==2){
                    LP[i][j] = 2;
                }
                else if(chars[i]==chars[j]){
                    LP[i][j] = LP[i+1][j-1]+2;
                }
                else{
                    LP[i][j] = max(LP[i+1][j],LP[i][j-1]);
                }
            }
        }
        return LP[0][LP.length-1];

    }

    static int max (int x, int y) { return (x > y)? x : y; }

    public void printMatrix(int [][] LP){
        for(int i=0;i<LP.length;i++){
            for(int j=0;j<LP.length;j++){
                System.out.print("  " + LP[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String arg[]){
        String strA = "AABCDEBAZ";
        LongestPalindromicSubsequence2 i = new LongestPalindromicSubsequence2();
        int x = i.longestPalindrome(3, strA);
        System.out.println("Length of Longest Palindrome in '" + strA + "' is- " + x);
    }
}