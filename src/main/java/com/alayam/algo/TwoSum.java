package com.alayam.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        List<Integer> listNum = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for( Integer i :listNum) {
            int diff = target - i;
            if(listNum.contains(diff)) {
                result[0] = listNum.indexOf(diff);
                result[1] = listNum.indexOf(i);
            }
        }

        return result;
    }

    //
    public void sortOneZeros(int[] arr){
        int i=0;
        int j= arr.length -1;
        while(i <= j) {
            while(arr[i] == 0) i++;
            while(arr[j] == 1) j--;

            if(i<=j && i < arr.length && j >=0 ){
                swap(arr, i, j);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

