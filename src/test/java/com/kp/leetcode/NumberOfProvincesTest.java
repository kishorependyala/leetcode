package com.kp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfProvincesTest {

    @Test
    void findCircleNum() {
        int[][] input1 = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        assertEquals(2,new NumberOfProvinces().findCircleNum(input1));

        int[][] input2 = new int[][]{{1,0,0,1}, {0,1,1,0},{0,1,1,1},{1,0,1,1}};
        assertEquals(1,new NumberOfProvinces().findCircleNum(input2));
    }
}