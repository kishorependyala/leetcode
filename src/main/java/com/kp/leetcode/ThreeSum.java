package com.kp.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        if(nums.length < 3){
            return solution;
        }
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();

        for(int i=0; i+2<sortedNums.length; i++){
            if( i>0 && sortedNums[i] == sortedNums[i-1]) {
                continue;
            }
            int j= i+1;
            int k = sortedNums.length -1;


            while ( j < k ){

                int target = sortedNums[i]+sortedNums[j]+sortedNums[k];

                if(target == 0){
                    List<Integer> newTriple = Arrays.asList(sortedNums[i],sortedNums[j],sortedNums[k]);// add to solution
                    solution.add(newTriple);
                    j++;
                    k--;
                    while( j < k && nums[j] == nums[j-1]) j++;
                    while( j < k && nums[k] == nums[k+1]) k--;
                }else if (target  > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return solution;
    }
}

