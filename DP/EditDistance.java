package com.debu.DP;

import java.util.Scanner;

/**
 * Created by Aspire V3 on 18-12-2017.
 */
public class EditDistance {

    static int editDistance(String str1, String str2, int i, int j, int m, int n, int edit) {
        if (i >= m || j >= n) {
            return edit;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return editDistance(str1, str2, ++i, ++j, m, n, edit);
        }

        return Math.min(editDistance(str1, str2, ++i, j, m, n, ++edit), editDistance(str1, str2, i, ++j, m, n, ++edit));
    }

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String s = sc.next();

            String str1 = "geek";
            String str2 = "gesek";

            int edit = 0;
            edit = editDistance(str1, str2, 0, 0, str1.length(), str2.length(), edit);
            System.out.println("minimum edits needed is " + edit);
    }
}
