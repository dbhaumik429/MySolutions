package com.debu.string;

public class SearchShortString {

    private static void checkShortStrPartOfLongStr(String str, String shortStr) {
        /*
        facebook -> f2eb2k
        --> f6k
        *
        * */


        for (int i = 0, j = 0; i < str.length() || j < shortStr.length(); ++i) {

            if (Character.isDigit(shortStr.charAt(j))) {
                Integer fulldigit = Integer.valueOf(shortStr.charAt(j));

                if(j>0 && Character.isDigit(shortStr.charAt(j-1))) {
                    Integer digit = Integer.valueOf(shortStr.charAt(j));

                    fulldigit = ( fulldigit * 10 ) + digit;
                }
            }else
            {
                if (str.charAt(i) == shortStr.charAt(j)) {
                    continue;

                }
            }


        }


    }

    public static void main(String[] args) {


    }
}
