package com.alayam.algorithm;

/**
 * Created by Tanvi on 9/3/2017.
 */
public class LPSSiva {
    static int longestPalindrome(int n, String s) {
        int dpMatrix[][] = new int[n][n]; //table to store subproblem


        for (int i = 0; i < n; i++)
            dpMatrix[i][i] = 1; //String with size 1 are palindrome


        int j = 0;
        //Starting from second column lets fill in the one diagonal
        // of the matrix using a Dyamic programing aproach
        for (int col = 2; col <= n; col++) {
            for (int i = 0; i < n - col + 1; i++) {
                j = i + col - 1;
                if (s.charAt(i) == s.charAt(j) && col == 2) {
                    dpMatrix[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dpMatrix[i][j] = dpMatrix[i + 1][j - 1] + 2;
                } else {
                    dpMatrix[i][j] = max(dpMatrix[i][j - 1], dpMatrix[i + 1][j]);
                }
            }
        }

        return dpMatrix[0][n - 1];
    }

    static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    public static void main(String[] args) {
        String strA = "bandana";
//        String s ="aaa";
//        int k = Integer.parseInt(args[1]);
//        System.out.println(longestPalindrome(s.length(), s));
//        String strA = "AABCDEBAZ";

        LongestPalindromicSubsequence i = new LongestPalindromicSubsequence();
        int x = i.findPalindrome(strA);
        System.out.println("Length of Longest Palindrome in '" + strA + "' is- " + x);
    }
}

     class LongestPalindromicSubsequence {

        public int findPalindrome(String A){
            char [] chars = A.toCharArray();  //Convery string to character array..
            int [][]LP = new int[chars.length][chars.length];
            //LP[i][j] - length of palindrome from ith index to jth index
            // all the characters in the string are palindrome by itself of length 1.
            //So all LP[i][i] =  1
            for(int i=0;i<chars.length;i++){
                LP[i][i] = 1;
            }

            for(int sublen = 2; sublen<=chars.length; sublen++){
                for(int i=0;i<=LP.length-sublen;i++){
                    int j = i+sublen-1;
                    if(chars[i]==chars[j] && sublen==2){
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
            printMatrix(LP);
            return LP[0][LP.length-1];

        }

         int max(int x, int y) {
             return (x > y) ? x : y;
         }


         public void printMatrix(int [][] LP){
            for(int i=0;i<LP.length;i++){
                for(int j=0;j<LP.length;j++){
                    System.out.print("  " + LP[i][j]);
                }
                System.out.println("");
            }
        }


    }
