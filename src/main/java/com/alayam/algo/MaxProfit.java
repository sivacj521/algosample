package com.alayam.algo;

public class MaxProfit {
    public static int maxProfit(int[] prices) {

        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;

    }
    //Testing maxDiff
    public static int maxDiff(int arr[])
    {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return (max_diff<0)? 0: max_diff;
    }

    public static void main(String[] args) {
//        int arr[] = {1, 2, 90, 10, 110};
        int arr[] = {10, 9, 6, 4, 2};
        System.out.println(MaxProfit.maxProfit(arr));
        System.out.println(MaxProfit.maxDiff(arr));
    }
}
