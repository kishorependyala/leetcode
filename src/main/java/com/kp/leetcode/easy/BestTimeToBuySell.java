package com.kp.leetcode.easy;

public class BestTimeToBuySell {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int price:prices){
            if(price < min){
                min = price;
            }else{
                if (price - min > max){
                    max = price - min;
                }
            }

        }
        return max;

    }
}
