package com.alayam.practice;

import java.util.stream.IntStream;

class CodilityProblem {

    /*
    A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non−empty parts: A[0], A[1], …, A[P − 1] and A[P], A[P + 1], …, A[N − 1].
The difference between the two parts is the value of: |(A[0] + A[1] + … + A[P − 1]) − (A[P] + A[P + 1] + … + A[N − 1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

Write a function that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

Example:
      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
We can split this tape in four places:
P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
In this case I would return 1 as it is the smallest difference.

N is an int, range [2..100,000]; each element of A is an int, range [−1,000..1,000]. It needs to be
     */

    static int tapeEqulibirum(int arr[]) {

        int totalSum = IntStream.of(arr).sum();
        int sumRight=0;
        int minDiff=Integer.MAX_VALUE;

        for(int i= arr.length-1; i>=0 ; i--) {
            sumRight += arr[i];

            int sumLeft = totalSum - sumRight;
            int diff = Math.abs(sumLeft - sumRight);
            if(diff < minDiff )
                minDiff = diff;
        }

        System.out.println("Sum:"+totalSum);
        return minDiff;

    }

    /*
    Given an array A of N integers from the set [0,1][0,1],
    interpret 0 as a car travelling east, and 1 as a car travelling west.
    A car with index P is said to pass car with index Q when P<Q and P
    is travelling east and Q is travelling west.
    Count the number of total pairs of cars passing each other.
     */

    static int passingCars(int arr[]) {
        int sum=0;
        return sum;
    }

    static int largestSumofContigousSubArray(int arr[]) {

        int runningSum=0;
        int maxSum=0;
        for(int i = 0; i< arr.length ; i++) {
            runningSum += arr[i];
            if(runningSum > maxSum)
                maxSum = runningSum;

            if (runningSum < 0)
                runningSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int arr[] = {3,1,2,4,3};
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Tape:" + CodilityProblem.tapeEqulibirum(arr));

        System.out.println("largestSum:"+ CodilityProblem.largestSumofContigousSubArray(arr));
    }
}
