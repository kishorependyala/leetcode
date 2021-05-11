package com.kp.leetcode;

public class ReverseInteger {

    public int reverse(int x) {

        long returnValue = 0 ;

        while (x > 0){
            int dividend = x%10;
            x = x/10;
            returnValue = returnValue*10 + dividend;
        }

        if(returnValue > Integer.MAX_VALUE || returnValue < Integer.MIN_VALUE)
            return 0;
        else
            return (int)returnValue;
    }

    public static void main(String[] args){
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}


