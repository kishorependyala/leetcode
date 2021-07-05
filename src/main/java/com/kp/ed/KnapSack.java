package com.kp.ed;

import javax.swing.*;

public class KnapSack {


    public static void main(String[] args){
        KnapSack knapSack = new KnapSack();
        int[] profits = {1,6,10,16};
        int[] weights = {1,2,3,5};

        int maxProfit = knapSack.solveKnapsack(profits,weights,7);
        System.out.println("Total knapsack profit " + maxProfit);
        maxProfit = knapSack.solveKnapsack(profits,weights,6);
        System.out.println("Total knapsack profit " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer dp[][] = new Integer[profits.length][capacity+1];

        return knapSackRecursiveWithMemory(dp, profits,weights,capacity,0);
    }

    private int knapSackRecursiveWithMemory(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex){
        if(capacity == 0 || currentIndex >= profits.length){
            return 0;
        }
        if(dp[currentIndex][capacity]!=null){
            return dp[currentIndex][capacity];
        }

        int profit1= 0;
        if( weights[currentIndex] <= capacity)
            profit1= profits[currentIndex]+knapSackRecursive(profits,weights,capacity - weights[currentIndex],currentIndex+1);

        int profit2 = knapSackRecursive(profits,weights,capacity,currentIndex+1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

    private int knapSackRecursive(int[] profits, int[] weights, int capacity, int currentIndex){
        if(capacity == 0 || currentIndex >= profits.length){
            return 0;
        }
        int profit1= 0;
        if( weights[currentIndex] <= capacity)
            profit1= profits[currentIndex]+knapSackRecursive(profits,weights,capacity - weights[currentIndex],currentIndex+1);

        int profit2 = knapSackRecursive(profits,weights,capacity,currentIndex+1);

        return Math.max(profit1,profit2);
    }
}
