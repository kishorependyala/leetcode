package com.kp.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void wordBreak() {

        assertEquals(true,new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}