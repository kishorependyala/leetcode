package com.kp.leetcode.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */

public class GoodStringsInWords {

    public int countCharactersBruteForce(String[] words, String chars){
        return Arrays.stream(words).mapToInt(str -> countCharactersBruteForce(str,chars)).sum();
    }

    public int countCharactersUsingMap(String[] words, String chars){
        return Arrays.stream(words).mapToInt(str -> countCharactersUsingMap(str,chars)).sum();
    }

    public int countCharactersUsingMapOptimized(String[] words, String chars){
        Map<Character, Integer> charsMap = toCharsMap(chars);
        return Arrays.stream(words).mapToInt(str -> countCharactersUsingMap(str,charsMap)).sum();
    }

    public int countCharactersUsingArray(String[] words, String chars){
        return Arrays.stream(words).mapToInt(str -> countCharactersUsingArray(str,chars)).sum();
    }

    public int countCharactersBruteForce(String word, String chars){
        if(word == null || chars == null){
            return 0;
        }
        int wordLength = word.length();
        int charsLength = chars.length();

        if(wordLength > charsLength){
            return 0;
        }
        StringBuilder sb = new StringBuilder(chars);

        for (int i = 0; i < wordLength; i++){
            int firstIndex = sb.indexOf(word.charAt(i)+"");
            if(firstIndex == -1){
                return 0;
            }
            sb.delete(firstIndex,firstIndex);
        }

        return wordLength;
    }

    public int countCharactersUsingMap(String word, String chars){

        Map<Character, Integer> charsMap = toCharsMap(chars);

        return countCharactersUsingMap(word, charsMap);
    }

    private int countCharactersUsingMap(String word, Map<Character, Integer> charsMap) {

        if(word == null || charsMap.isEmpty()){
            return 0;
        }
        int wordLength = word.length();

        if(wordLength > charsMap.size()){
            return 0;
        }

        Map<Character,Integer> clonedCharsMap = new HashMap<>(charsMap);


        for (int i = 0; i < wordLength; i++){
            char c = word.charAt(i);
            Integer count= clonedCharsMap.get(c);
            if (count == null || count == 0){
                return 0;
            }
            clonedCharsMap.put(c,count--);
        }

        return wordLength;
    }

    private Map<Character, Integer> toCharsMap(String chars) {
        if(chars == null){
            return Collections.EMPTY_MAP;
        }
        Map<Character,Integer> charsMap = new HashMap<>();
        for(int i = 0; i< chars.length(); i++){
            char c = chars.charAt(i);
            Integer count = charsMap.get(c);
            count = count==null?1:count+1;
            charsMap.put(c,count);
        }
        return charsMap;
    }

    public int[] toArray(String chars) {
        if(chars == null){
            return null;
        }

        int[] charsCount= new int[26];
        for(int i = 0; i< chars.length(); i++){
            int charNum = chars.charAt(i);
            charsCount[charNum-97] += 1;
        }
        return charsCount;
    }

    public int countCharactersUsingArray(String word, String chars){
        int[] charCounts = toArray(chars);
        return countCharactersUsingArray(word, charCounts);
    }

    private int countCharactersUsingArray(String word, int[] charCounts) {

        if(charCounts == null){
            return 0;
        }
        int wordLength = word.length();

        if(wordLength > charCounts.length){
            return 0;
        }

        int[] clonedCharCounts = charCounts.clone();

        for (int i = 0; i < wordLength; i++){
            int charNum = word.charAt(i);
            charNum = charNum-97;

            if (clonedCharCounts[charNum]==0){
                return 0;
            }else {
                clonedCharCounts[charNum]--;
            }
        }
        return wordLength;
    }
}
