package com.alayam.practice;

import java.util.Arrays;

public class CyclicRotation {

    static public void cycleVaka(int arr[], int x) {
        int currLoc = 0;
        int tempLoc = arr.length - x - currLoc;
        int temp = arr[currLoc];

        for (int i=0; i < arr.length; i++) {
            System.out.println(tempLoc+":"+temp);
            arr[tempLoc] = temp;
            tempLoc = (arr.length - x + tempLoc)%arr.length;

            temp = arr[tempLoc];

        }
    }

    static public boolean rotateArray(int arr[], int numOfRotation){
        numOfRotation = numOfRotation % arr.length;

        int result[] = new int [arr.length];
        int j=0;
        for(int i =numOfRotation ; i< arr.length; i++,j++) {
           result[j] = arr[i];
        }
        for(int k =0 ; k < numOfRotation; k++){
            result[j++] = arr[k];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
        return true;

    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
       // CyclicRotation.rotateArray(arr,4);
       // System.out.println(Arrays.toString(arr));
        CyclicRotation.cycleVaka(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
