package com.kp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        assertEquals(49,new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1,new ContainerWithMostWater().maxArea(new int[]{1,1}));
        assertEquals(16,new ContainerWithMostWater().maxArea(new int[]{4,3,2,1,4}));
        assertEquals(2,new ContainerWithMostWater().maxArea(new int[]{1,2,1}));
    }
}