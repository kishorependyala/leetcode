package com.kp.rbc;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonSubstring {

    public String lcs(String inputStr, String[] strArray){

        String longestSubString="";

        for(String str : strArray){
            String lcsString = lcs(inputStr,str);
            if(longestSubString.length() < lcsString.length()){
                longestSubString = lcsString;
            }
        }
        return longestSubString;
    }

    public String lcsTake2(String inputStr, String[] strArray){
        return Arrays.stream(strArray)
                .map(str -> lcs(inputStr,str))
                .max(Comparator.comparing(String::length)).get();
    }

    public String lcsTake2(String input, String sourceStr){
        int counter=0;
        String longestCommonString = "";
        if (input == null || sourceStr == null){
            return longestCommonString;
        }
        StringBuilder sb = new StringBuilder();

        for (char x : input.toCharArray()){
            if(counter >= sourceStr.length()){
                break;
            }
            if(x == sourceStr.charAt(counter)){
                sb.append(x);
            }
            else{
                if(longestCommonString.length() < sb.length()){
                    longestCommonString = sb.toString();
                }
                sb.delete(0,sb.length());
            }
            counter++;
        }
        return longestCommonString;

    }

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1,text2).length();
    }

    public String lcs(String str1, String str2) {

        String shortestSubStr = "";

        if (str1 == null || str2 == null){
            return shortestSubStr;
        }
        StringBuilder sb = new StringBuilder();

        for(int index=0; index<str2.length(); index++){
                int str1Index=0;
                int str2Index=index;

                while( str1Index< str1.length() && str1.charAt(str1Index)!=str2.charAt(str2Index)){
                    str1Index++;
                }
                while(str1Index<str1.length() && str2Index < str2.length() &&  str1.charAt(str1Index)==str2.charAt(str2Index)){
                    sb.append(str1.charAt(str1Index));
                    str1Index++;
                    str2Index++;
                }
                if(shortestSubStr.length() < sb.length()){
                    shortestSubStr = sb.toString();

                }
            sb.delete(0,sb.length());
        }
        return shortestSubStr;
    }
}


