package com.debu.string;

/**
 * Created by Aspire V3 on 20-05-2018.
 */
public class LongestPalindromeSubstring {

    static boolean checkPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // A utility function to print a substring str[low..high]
    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    static void printMatrix(boolean[][] table, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int longestPalSubstr(String str) {
        int n = str.length();   // get length of input string

        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

       // printMatrix(table, n);

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }


        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) ==
                        str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        printMatrix(table, n);


        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength; // return length of LPS
    }

    public static void on3solution(String s) {
        int maxCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            int count = 0;
            for (int j = s.length() - 1; j > i; --j) {
                if (checkPal(s, i, j))
                    count = (j - i + 1);
                maxCount = (maxCount < count) ? count : maxCount;
            }
        }
        System.out.println(maxCount);
    }

    public static void main(String[] args) {

        String s = "geeksskeeg";

        //on3solution(s);
        System.out.println("Length is: " +
                longestPalSubstr(s));

    }
}
