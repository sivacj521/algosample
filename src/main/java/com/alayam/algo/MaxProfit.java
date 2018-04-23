package com.alayam.algo;

public class MaxProfit {

    /*
    ** Maximum profit you can make on a stock market
     */
    public int maxProfit(int[] prices) {

        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i - 1];
            maxCur = Math.max(0, maxCur);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;

    }
    //Testing maxDiff
    public int maxDiff(int arr[])
    {
        if(arr.length <=1) return 0;

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
        int arr[] = {1, 2, 90, 10, 32};
//        int arr[] = {10, 9, 6, 4, 2};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(arr));
        System.out.println(maxProfit.maxDiff(arr));
    }
}
