package com.debu.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspire V3 on 31-05-2017.
 */
public class ValidParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        new ValidParanthesis().generateParenthesis(3);
    }
}
