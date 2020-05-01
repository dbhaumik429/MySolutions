package com.debu.DP;
/*
*
* You are given an n*m grid which contains lower case English letters.
* How many times does the phrase "saba" appear horizontally, vertically, and diagonally in the grid?

Input format

First line: Two integer n and m, where n denotes (1 <= n,m <= 100) the number of rows and m denotes the number
 of columns in the grid
Next n lines: Each line must contain a string of length m which contains lower-case English letters only
Output format

Print the number of times the word “saba” appears in the grid.

SAMPLE INPUT
5 5
safer
amjad
babol
aaron
songs
SAMPLE OUTPUT
2

*
* */

import java.util.Arrays;
import java.util.List;

public class GridAndPhraseRecursive {

   /* private Integer countPhrase(String[][] mat, Integer m, Integer n) {

    }*/

    public static void main(String[] args) {
        String phrase = "saba";
        Integer n = 5;
        Integer m = 5;

        List<String> mat = Arrays.asList("safer",
                "amjad",
                "babol",
                "aaron",
                "songs");

        Character[][] matrix = new Character[m][n];

        for (int i = 0; i < n; i++) {
            String word = mat.get(i);
            for (int j = 0; j < word.length(); ++j) {

                matrix[j][i] = word.charAt(i);
            }

        }


    }
}
