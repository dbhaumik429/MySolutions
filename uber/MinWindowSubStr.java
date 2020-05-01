package com.debu.uber;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubStr {
    public String minWindow(String s, String t) {

        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> wordMap = new HashMap<>();

        //get the counts of the distinct chars
        for (int i = 0; i < t.length(); ++i) {
            Character c = t.charAt(i);
            Integer count = charMap.getOrDefault(c, 0);
            ++count;
            charMap.put(c, count);
        }

        int st = 0;
        int en = 0;
        int mst=0;
        int men=0;
        int minLen = Integer.MAX_VALUE;

        int formed = 0;
        int required = charMap.size();

        //iterate over the string s
        for (; en < s.length(); ++en) {
            Character c = s.charAt(en);

            int words = wordMap.getOrDefault(c, 0);
            ++words;
            wordMap.put(c, words);

            if (charMap.containsKey(c) && words == charMap.get(c)) {
                //find out the string which contains all the required chars. formed should become equal to required
                formed++;
            }

            while (st <= en && formed == required) {

                c = s.charAt(st);

                if( minLen == Integer.MAX_VALUE || (en - st +1) < minLen )
                {
                    minLen = en - st + 1;
                    mst=st;
                    men=en;
                }

                words = wordMap.getOrDefault(c, 0);
                --words;
                wordMap.put(c, words);

                // reduce the start st till we discard the extra chars
                if (charMap.get(c) != null && charMap.get(c) > words) {
                    formed--;
                }

                st++;
            }

        }

        if (minLen != Integer.MAX_VALUE) {
            // substring end index does not take the last one so add plus 1
            return s.substring(mst, men+1);
        }

        return "";
    }


    public static void main(String[] args) {
        String s = "debdatta";
        String t = "bed";

/*        String s = "ADOBECODEBANC";
        String t = "ABC";*/
        System.out.println(new MinWindowSubStr().minWindow(s, t));
    }
}

