package com.kp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void coinChange() {
        assertEquals(20, new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));
        assertEquals(3, new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, new CoinChange().coinChange(new int[]{2}, 3));
        assertEquals(0, new CoinChange().coinChange(new int[]{1}, 0));
        assertEquals(1, new CoinChange().coinChange(new int[]{1}, 1));
        assertEquals(2, new CoinChange().coinChange(new int[]{1}, 2));

    }

    @Test
    void coinChangeRec() {
        assertEquals(20, new CoinChange().coinChangeRecursion(new int[]{186, 419, 83, 408}, 6249));
        assertEquals(3, new CoinChange().coinChangeRecursion(new int[]{1, 2, 5}, 11));
        assertEquals(-1, new CoinChange().coinChangeRecursion(new int[]{2}, 3));
        assertEquals(0, new CoinChange().coinChangeRecursion(new int[]{1}, 0));
        assertEquals(1, new CoinChange().coinChangeRecursion(new int[]{1}, 1));
        assertEquals(2, new CoinChange().coinChangeRecursion(new int[]{1}, 2));

    }

    @Test
    void coinChangeBottomUp() {
        assertEquals(20, new CoinChange().coinChangeBottomUp(new int[]{186, 419, 83, 408}, 6249));
    }

    @Test
    void coinChangeTopDown() {
        //assertEquals(3, new CoinChange().coinChangeTopDown(new int[]{1, 2, 5}, 11));
        assertEquals(20, new CoinChange().coinChangeTopDown(new int[]{186, 419, 83, 408}, 6249));
    }
}