package com.alayam.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsTest {

    @Test
    public void testEmptyString() {
        assertEquals("", ReverseWords.reverseWords(""));
    }

    @Test
    public void testWithSingleWord() {
        assertEquals("awesome", ReverseWords.reverseWords("awesome"));
    }

    @Test
    public void testWithTwoWords() {
        assertEquals("is awesome", ReverseWords.reverseWords("awesome is"));
    }

    @Test
    public void testWithSentence() {
        assertEquals("awesome is codereview", ReverseWords.reverseWords("codereview is awesome"));
    }

}