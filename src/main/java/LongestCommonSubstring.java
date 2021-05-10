
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

    public String lcs(String inputStr, String str) {
        String shortestSubStr = "";
        if (inputStr == null || str == null){
            return shortestSubStr;
        }

        for(int i=0;i<inputStr.length();i++){

            for(int j=0; j<str.length(); j++){


                    StringBuilder sb = new StringBuilder();

                    while(i<inputStr.length() && j < str.length() &&  inputStr.charAt(i)==str.charAt(j)){
                        sb.append(inputStr.charAt(i));
                        i++;
                        j++;
                    }
                    if(shortestSubStr.length() < sb.length()){
                        shortestSubStr = sb.toString();
                    }


            }
        }
        return shortestSubStr;
    }
}


