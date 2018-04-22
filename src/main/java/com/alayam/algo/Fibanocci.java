package com.alayam.algo;

public class Fibanocci {

    static int mem[] = new int[100];

    static int fib(int n) {
        if(n<=0){
            return 0;
        }else if( n == 1){
            return 1;
        }else if(mem[n] == 0){
            mem[n] = fib(n-1) + fib(n-2);
        }
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibanocci.fib(8));
    }
}
