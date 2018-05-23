package com.alayam.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * Find the index of two integers who's sum is the total
 */
public class TwoSum {

    public int[] twoSum2(int[] nums, int target) {
        if(nums==null || nums.length<2)
            return new int[]{0,0};

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target-nums[i], i);
            }
        }

        return new int[]{0,0};
    }

    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        List<Integer> listNum = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

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

