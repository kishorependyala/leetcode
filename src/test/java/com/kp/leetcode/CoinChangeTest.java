package com.kp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void coinChange() {
        assertEquals(3,new CoinChange().coinChange(new int[]{1,2,5},11));
        assertEquals(-1,new CoinChange().coinChange(new int[]{2},3));
        assertEquals(0,new CoinChange().coinChange(new int[]{1},0));
        assertEquals(1,new CoinChange().coinChange(new int[]{1},1));
        assertEquals(2,new CoinChange().coinChange(new int[]{1},2));
    }
}