package com.debu.string;


public class RemoveDups {

    //assumption is lower case
    public static char[] removeDups(char[] word) {
        Boolean[] checkArr = new Boolean[256];
        for (int i = 0; i < 256; i++) {
            checkArr[i] = false;
        }

        int replaceIndex = 0;

        for (int i = 0; i < word.length; i++) {
            char c = word[i];

            if (!checkArr[c - 'a']) {

                checkArr[c - 'a'] = true;

                word[replaceIndex]=word[i];
                replaceIndex++;
            }

            if (i != replaceIndex) {
                word[replaceIndex] = word[i];
                replaceIndex = i;
            }



        }

        return word;

    }

    public static void removeDuplicatesEff(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;
        boolean[] hit = new boolean[256];
        for (int i = 0; i < 256; ++i) {
            hit[i] = false;
        }
        hit[str[0]] = true;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            if (!hit[str[i]]) {
                str[tail] = str[i];
                ++tail;
                hit[str[i]] = true;
            }
        }
        str[tail] = 0;

        int i=0;
        while(str[i]!=0)
        {
            System.out.print(str[i++]);
        }
    }

    public static void main(String[] args) {
        String word = "abcaabdec";

        removeDuplicatesEff(word.toCharArray());

    }
}
