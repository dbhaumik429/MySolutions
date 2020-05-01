package com.debu.matrix;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Aspire V3 on 10-09-2017.
 */
public class CrossWords {

    static class Node {

        public int x;
        public int y;
        public int horizontalLen;
        public int verticalLen;

        @Override
        public String toString() {
            return x + "," + y + "," + horizontalLen + "," + verticalLen;
        }
    }


    public static Set<Node> crossWordsOpenPosition(String[][] mat) {
        Set<Node> coOrds = new HashSet<>();

        //row wise traversal
        for (int i = 0; i <= 10; ++i) {
            int len = 0;
            Node node = new Node();


            for (int j = 0; j <= 10; ++j) {

                if (i == 10 || j == 10 || mat[i][j] == "+") {

                    if (len > 1) {
                        node.horizontalLen = len;
                        coOrds.add(node);
                        len = 0;
                    }

                } else {

                    if (j != 0 && (mat[i][j] != mat[i][j - 1]))
                        len = 0;

                    if (len == 0) {
                        node.x = i;
                        node.y = j;
                    }
                    len++;
                }
            }
        }

        // col wise traversal - need to optimize it
        for (int j = 0; j <= 10; ++j) {
            int len = 0;
            Node node = new Node();

            for (int i = 0; i <= 10; ++i) {

                if (i == 10 || j == 10 || mat[i][j] == "+") {

                    if (len > 1) {
                        node.verticalLen = len;
                        coOrds.add(node);
                        len = 0;

                    }

                } else {

                    if (i != 0 && (mat[i][j] != mat[i - 1][j]))
                        len = 0;

                    if (len == 0) {
                        node.x = i;
                        node.y = j;
                    }

                    len++;
                }
            }
        }

        coOrds.forEach(System.out::println);

        return coOrds;
    }

    private static Map<Integer, List> getWords(String[] words) {
        Map<Integer, List> res = new HashMap<>();
        List<String> names = new ArrayList<>();




       // Arrays.stream(words).forEach((p) -> res.put(p.length(),
                      // return ((res.get(p.length()) != null )? return res.get(p.length()); : return new ArrayList<String>();)
                        //        .add(p)));



        res.forEach((key, val) -> System.out.println("number " + key + " , " + "value " + val));

        return res;
    }

    public static void fillCrossWords(String[][] mat, String[] words) {
        Set<Node> coOrds = crossWordsOpenPosition(mat);

        //find the overlapping coords
     //   Map<Integer, String> wordsMap = getWords(words);


    }


    public static void main(String[] args) {
        String[] words = {"LONDON", "DELHI", "ICELAND", "ANKARA"};
        String[][] mat = {
                {"+", "-", "+", "+", "+", "+", "+", "+", "+", "+"},
                {"+", "-", "+", "+", "+", "+", "+", "+", "+", "+"},
                {"+", "-", "+", "+", "+", "+", "+", "+", "+", "+"},
                {"+", "-", "-", "-", "-", "-", "+", "+", "+", "+"},
                {"+", "-", "+", "+", "+", "-", "+", "+", "+", "+"},
                {"+", "-", "+", "+", "+", "-", "+", "+", "+", "+"},
                {"+", "+", "+", "+", "+", "-", "+", "+", "+", "+"},
                {"+", "+", "-", "-", "-", "-", "-", "-", "+", "+"},
                {"+", "+", "+", "+", "+", "-", "+", "+", "+", "+"},
                {"+", "+", "+", "+", "+", "-", "+", "+", "+", "+"}
        };

        fillCrossWords(mat, words);

    }
}



