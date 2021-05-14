package com.kp.leetcode.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodStringsInWordsTest {

    @Test
    void test() {
        assertEquals(true,true);
        new GoodStringsInWords().toArray("abc");
    }
    @Test
    void countCharactersBruteForce() {
        assertEquals(6,new GoodStringsInWords().countCharactersBruteForce(new String[]{"cat","bt","hat","tree"},"atach"));
        assertEquals(10,new GoodStringsInWords().countCharactersBruteForce(new String[]{"hello","world","leetcode"},"welldonehoneyr"));
    }

    @Test
    void countCharactersUsingArray() {
        assertEquals(6,new GoodStringsInWords().countCharactersUsingArray(new String[]{"cat","bt","hat","tree"},"atach"));
        assertEquals(10,new GoodStringsInWords().countCharactersUsingArray(new String[]{"hello","world","leetcode"},"welldonehoneyr"));
    }

    @Test
    void countCharactersUsingMap() {
        assertEquals(6,new GoodStringsInWords().countCharactersUsingMap(new String[]{"cat","bt","hat","tree"},"atach"));
        assertEquals(10,new GoodStringsInWords().countCharactersUsingMap(new String[]{"hello","world","leetcode"},"welldonehoneyr"));
    }

    @Test
    void countCharactersUsingMapOptimized() {
        assertEquals(6,new GoodStringsInWords().countCharactersUsingMapOptimized(new String[]{"cat","bt","hat","tree"},"atach"));
        assertEquals(10,new GoodStringsInWords().countCharactersUsingMapOptimized(new String[]{"hello","world","leetcode"},"welldonehoneyr"));
    }

    @Test
    void testCountCharacters() {
        assertEquals(3,new GoodStringsInWords().countCharactersBruteForce("cat","atach"));
        assertEquals(0,new GoodStringsInWords().countCharactersBruteForce("bt","atach"));
        assertEquals(3,new GoodStringsInWords().countCharactersBruteForce("hat","atach"));
        assertEquals(0,new GoodStringsInWords().countCharactersBruteForce("tree","atach"));
    }

    @Test
    void testCountCharactersUsingMap() {
        assertEquals(3,new GoodStringsInWords().countCharactersUsingMap("cat","atach"));
        assertEquals(0,new GoodStringsInWords().countCharactersUsingMap("bt","atach"));
        assertEquals(3,new GoodStringsInWords().countCharactersUsingMap("hat","atach"));
        assertEquals(0,new GoodStringsInWords().countCharactersUsingMap("tree","atach"));
    }

    @Test
    void testCountCharactersUsingArray() {
        assertEquals(3,new GoodStringsInWords().countCharactersUsingArray("cat","atach"));
        assertEquals(0,new GoodStringsInWords().countCharactersUsingArray("bt","atach"));
        assertEquals(3,new GoodStringsInWords().countCharactersUsingArray("hat","atach"));
        assertEquals(0,new GoodStringsInWords().countCharactersUsingArray("tree","atach"));
    }
}