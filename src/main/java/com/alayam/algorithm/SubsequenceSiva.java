package com.alayam.algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Tanvi on 9/3/2017.
 */
public class SubsequenceSiva {

    public static boolean isPalindrome(String s){
        if(s==null||s.length()==0) return false;

        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    static int longest;

    public static void cachePalindromeFromSubsequence(String prefix, String remaining, int k) {
        if (k == 0) {
            if(isPalindrome(prefix)) {
                longest = (prefix.length() < longest)? longest : prefix.length();
            }
            return;
        }
        if (remaining.length() == 0) return;

        cachePalindromeFromSubsequence(prefix + remaining.charAt(0), remaining.substring(1), k-1);
        cachePalindromeFromSubsequence(prefix, remaining.substring(1), k);
    }



    static int longestPalindrome(int n, String s) {
        //find all possible palindrome subsequences.
        for(int i=0; i<= n; i++)
            cachePalindromeFromSubsequence("", s, i);

        return longest;
    }


    public static void main(String[] args) {
//        String s = "bandana";
        String s ="aaa";
//        int k = Integer.parseInt(args[1]);
        System.out.println(longestPalindrome(s.length(), s));
    }
}