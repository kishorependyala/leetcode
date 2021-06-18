package com.kp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> lookupMap = new HashMap<>();
        int[] answer = new int[2];

        for(int i=0;i<nums.length;i++){
            if(lookupMap.containsKey(nums[i])){
                answer[0]=lookupMap.get(nums[i]);
                answer[1]=i;
            }else{
                lookupMap.put(target - nums[i],i);
            }
        }
        return answer;
    }

    public int[] twoSum(int[] nums, int target, int indexToIgnore) {

        Map<Integer,Integer> lookupMap = new HashMap<>();
        int[] answer = new int[2];

        for(int i=0;i<nums.length;i++){
            if(i==indexToIgnore){
                continue;
            }
            if(lookupMap.containsKey(nums[i])){
                answer[0]=lookupMap.get(nums[i]);
                answer[1]=i;
                return new int[]{nums[answer[0]],nums[i]};
            }else{
                lookupMap.put(target - nums[i],i);
            }
        }
        return null;
    }

}
