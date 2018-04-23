package com.alayam.algo;

public class ReverseWords {

    public static String reverseWords(String sentence) {
        String[] parts = sentence.split(" ");

        StringBuilder builder = new StringBuilder();
        builder.append(parts[parts.length - 1]);

        for (int i = parts.length - 2; i >= 0; --i) {
            builder.append(" ").append(parts[i]);
        }

        return builder.toString();
    }
}
