package com.alayam.algo;

public class Fibanocci {

    long mem[] = new long[1000];


    long fib(int n) {
        long a=0,b=1,c =0;
        if(n == 0 ) return 0;
        if (n == 1 ) return 1;
        for(int i = 2; i<=n; i++){
            c = a +b;
            a=b;
            b=c;
        }
        return c;
    }

    long fibRecursive(int n) {
        if(n<=0){
            return 0;
        }else if( n == 1){
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }

    }

    long fibMemoization(int n) {
        if(n<=0){
            return 0;
        }else if( n == 1){
            return 1;
        }else if(mem[n] == 0){
            mem[n] = fibMemoization(n-1) + fibMemoization(n-2);
        }
        return mem[n];
    }

    public static void main(String[] args) {
        Fibanocci fibanocci = new Fibanocci();
        int n = 100;
        long start = System.currentTimeMillis();
        System.out.println(fibanocci.fib(n));
        System.out.println(fibanocci.fibMemoization(n));
        System.out.println(fibanocci.fibRecursive(n));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

}
