package com.alayam.algo;

import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    @Test
    public void testTwosum(){
        TwoSum twoSum = new TwoSum();
        int a[] = new int[] {3,2,4};
        int[] result = twoSum.twoSum(a, 6);


    }

    @Test
    public void testSort() {
        TwoSum twoSum = new TwoSum();
        int a[] = new int[] {1,0,1,1,0,1,1,0,1,1,0,0};
        twoSum.sortOneZeros(a);
        System.out.println("result:"+ Arrays.toString(a));
    }

}