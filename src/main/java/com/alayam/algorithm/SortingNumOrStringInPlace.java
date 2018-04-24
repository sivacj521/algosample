package com.alayam.algorithm;

import java.util.*;

/**
 * Created by Tanvi on 9/3/2017.
 * Program to sort a sentence with strings and numbers by keeping string's and number postion intact
 * eg: Input: car truck 8 4 bus 6 1
 *     output: bus car 1 4 truck 6 8
 */

public class SortingNumOrStringInPlace {

    static String sortNumbersAndLettersByKeepingPositionInplace(String input){
        String[] split = input.split(" ");
        String result ;
        boolean [] isNumber =  new boolean[split.length];
        List<String> strQ = new ArrayList<>();
        List<Integer> numberQ = new ArrayList<>();
        //Split the string
        int i=0;
        for (String s: split) {
            try {
                numberQ.add(Integer.parseInt(s));
                isNumber[i++] = true;
            } catch (Exception e) {
                strQ.add(s);
                isNumber[i++] = false;
                //this must be a string add it to String queue;
            }
        }

        System.out.println(strQ);
        System.out.println(numberQ);

        Collections.sort(strQ);
        Collections.sort(numberQ);

        StringBuilder out = new StringBuilder();
        for (int j = 0; j < split.length; j++) {
            if(isNumber[j]) {
                out.append(numberQ.remove(0) + " ");
            }else {
                out.append(strQ.remove(0)+ " ");
            }
        }

        Iterator<String> iterator = strQ.iterator();
        while (iterator.hasNext()){
            out.append(iterator.next()+ " ");
        }

        Iterator<Integer> iterator1 = numberQ.iterator();
        while (iterator1.hasNext()){
            out.append(iterator1.next()+ " ");
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String inStr[] = {
                "8 4 8 6 1 -2 9 5",
                "car truck 8 4 bus 6 1",
                ""};

        for(String s: inStr){
            System.out.println("================================");
            System.out.println("In: " + s);
            String out = SortingNumOrStringInPlace.sortNumbersAndLettersByKeepingPositionInplace(s);
            System.out.println("Out: " + out);
        }

    }
}
