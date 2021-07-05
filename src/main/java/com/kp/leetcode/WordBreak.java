package com.kp.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    private Map<String,Boolean> cache = new HashMap<>();


    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.isEmpty()){
            return true;
        }
        if(cache.containsKey(s)){
            return cache.get(s);
        }
        for(String word: wordDict){
            if (s.startsWith(word)) {
                String subStr = s.substring(word.length(), s.length());
                //System.out.println(subStr);
                boolean returnValue = wordBreak(subStr, wordDict);
                if(returnValue) {
                    cache.put(s,true);
                    return true;
                }
            }
        }
        cache.put(s,false);
        return false;
    }
}
