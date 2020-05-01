package com.debu.backtracking;

import java.util.*;

/**
 * Created by Aspire V3 on 31-05-2017.
 */
public class LetterCombination {



    private void backtrack(List<String> result, String currentWord,String digitsLeft, Map<String, String> letterDigitMap)
    {

        if(digitsLeft.length() == 0)
        {
            result.add(currentWord);
            return;
        }

        String word = letterDigitMap.get(digitsLeft.substring(0,1));

        for(int i=0; i<word.length();++i)
        {
            backtrack(result, currentWord + word.charAt(i), digitsLeft.substring(1), letterDigitMap);
         //   System.out.println(result);
        }

    }

    public List<String> generateCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        Map<String, String> letterDigitMap = new HashMap<>();

        letterDigitMap.put("2", "abc");
        letterDigitMap.put("3", "def");
        letterDigitMap.put("4", "ghi");
        letterDigitMap.put("5", "jkl");
        letterDigitMap.put("6", "mno");
        letterDigitMap.put("7", "pqrs");
        letterDigitMap.put("8", "tuv");
        letterDigitMap.put("9", "wxyz");



        backtrack(ans, "", digits, letterDigitMap);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombination().generateCombinations("23").
                equals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
    }
}
