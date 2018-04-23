package com.alayam.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfitTest {
    @Test
    public void maxProfit() throws Exception {
        MaxProfit maxProfit = new MaxProfit();
        int arr[] ={1,2};
        assertEquals(1,maxProfit.maxProfit(arr));
        assertEquals(1,maxProfit.maxDiff(arr));

        int arr1[] ={1};
        assertEquals(0,maxProfit.maxProfit(arr1));
        assertEquals(0,maxProfit.maxDiff(arr1));
    }
}