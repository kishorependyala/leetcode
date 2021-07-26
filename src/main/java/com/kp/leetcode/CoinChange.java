package com.kp.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int target = 1; target < dp.length; target++) {
            dp[target] = dp.length;
            for (int coin : coins) {
                if (target >= coin) {
                    dp[target] = Math.min(dp[target], dp[target - coin] + 1);
                }
            }
        }
        return dp[amount] == dp.length ? -1 : dp[amount];
    }

    private Map<Integer, Integer> cache = new HashMap<>();

    public int coinChangeRecursion(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0){
            return -1;
        }
        if (cache.containsKey(amount)) {
            //System.out.println(amount+" "+cache.get(amount));
            return cache.get(amount);
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i <coins.length; i++) {
            int coinAnswer = coinChangeRecursion(coins, amount - coins[i]);
            if(coinAnswer > -1 && coinAnswer < min){
                min = 1+coinAnswer;
            }
        }
        min=min==Integer.MAX_VALUE?-1:min;
        cache.put(amount, min);
        return cache.get(amount);
    }

    public int coinChangeRec(int[] coins, int amount){
        if(amount < 0) return 0;
        return helper(coins,amount, new int[amount]);
    }

    private int helper(int[] coins, int amount, int[] dp) {
        if(amount==0){
            return 0;
        }
        if(amount <0){
            return -1;
        }
        if(dp[amount-1]!=0) return dp[amount-1];

        int min = Integer.MAX_VALUE;

        for(int coin:coins){
            int res = helper(coins,amount-coin, dp);
            if(res >=0 && res < min){
                min = 1 + res;
            }
        }
        dp[amount-1] = (min == Integer.MAX_VALUE)?-1:min;
        return dp[amount-1];

    }


    public int coinChangeBottomUp(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        int[] coinTracker = new int[amount+1];

        for(int i=1; i<=amount; i++){
            dp[i]=dp.length;
            for(int coin:coins){
                if(i >= coin){
                    if(dp[i] > dp[i-coin]+1){
                        coinTracker[i]=coin;
                    }
                   dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        int value = amount;

        while(value > 0 ){
            System.out.print(coinTracker[value]+" ");
            value = value - coinTracker[value];

        }
        return dp[amount]==dp.length?-1:dp[amount];

    }

    public int coinChangeTopDown(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        return coinChangeTopDownRecursion(coins, amount, dp);
    }

    private int coinChangeTopDownRecursion(int[] coins, int amount, int[] dp) {
        if(amount==0){
            return 0;
        }else if(amount < 0){
            return -1;
        }
/*        if(dp[amount]!=0){
            return dp[amount];
        }*/
        int minCount = Integer.MAX_VALUE;
        for(int coin:coins){
            int value = coinChangeTopDownRecursion(coins,amount-coin,dp);
            if(value!=-1 && value < minCount){
                minCount = value;
            }
        }
        dp[amount]=minCount==Integer.MAX_VALUE?-1:minCount+1;
        return dp[amount];
    }
}
