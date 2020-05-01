package com.debu.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aspire V3 on 05-09-2017.
 */
public class LongestSubstringWithoutRepeat {

    public static int getLongestSubString(String s)
    {
        if(s.length()==0)
            return 0;

        if(s.length() == 1)
            return 1;

        int n = s.length(), ans = 0;

        Map<Character, Integer> map = new HashMap<>(); // current index of character

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++)
        {
            if (map.containsKey(s.charAt(j))) {
                //i = Math.max(map.get(s.charAt(j)), i);
                i = map.get(s.charAt(j));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args)
    {
            String str="pwwkew";
            System.out.println(getLongestSubString(str));
    }
}
