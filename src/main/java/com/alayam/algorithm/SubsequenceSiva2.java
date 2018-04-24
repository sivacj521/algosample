package com.alayam.algorithm;

/**
 * Created by Tanvi on 9/3/2017.
 */
public class SubsequenceSiva2 {

    // Returns the length of the longest palindromic subsequence in seq
    static int longestPalindromeDelegate(String s, int i, int j)
    {
        // If there is only 1 character
        if (i == j)
            return 1;

        // If there are only 2 characters and both are same
        if (s.charAt(i) == s.charAt(j) && i + 1 == j)
            return 2;

        // If the first and last characters match
        if (s.charAt(i) == s.charAt(j))
            return longestPalindromeDelegate (s, i+1, j-1) + 2;

        // If the first and last characters do not match
        return max( longestPalindromeDelegate(s, i, j-1), longestPalindromeDelegate(s, i+1, j) );
    }


    static int longestPalindrome(int n, String s) {
        return longestPalindromeDelegate(s,0, n-1);
    }

    static int longestPalindromeWorkingSolution(int n, String s)
    {
        int dpMatrix[][] = new int[n][n]; //table to store subproblem


        for (int i=0; i<n; i++)
            dpMatrix[i][i] = 1; //String with size 1 are palindrome


        for (int col= 2; col<=n; col++)
        {
            for (int j=0,i=0; i<n-col +1; i++)
            {
                j = i+col -1;
                if (s.charAt(i) == s.charAt(j) && col == 2)
                    dpMatrix[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j))
                    dpMatrix[i][j] = dpMatrix[i+1][j-1] + 2;
                else
                    dpMatrix[i][j] = max(dpMatrix[i][j-1], dpMatrix[i+1][j]);
            }
        }

        return dpMatrix[0][n-1];
    }

    static int max (int x, int y) { return (x > y)? x : y; }

    public static void main(String[] args) {
        String s = "bandana";
//        String s ="aaa";
//        int k = Integer.parseInt(args[1]);
        System.out.println(longestPalindrome(s.length(), s));
    }
}