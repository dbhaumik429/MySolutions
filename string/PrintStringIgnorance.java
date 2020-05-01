package com.debu.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintStringIgnorance {


    public static StringBuilder printStringIgnorance(String text) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character c = Character.toLowerCase(text.charAt(i));
            Integer count = 1;
            Boolean skip = false;
            if (countMap.get(c) != null) {
                count = countMap.get(c);
                ++count;
                if (count % 2 == 0) {
                    skip = true;
                }
            }

            countMap.put(c, count);
            if (!skip)
                result.append(c);

        }

        return result;

    }


    public static void main(String[] args) {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t > 0) {
            // Input the size of the array

            String text = sc.next();
            text += sc.nextLine();

            // Compute and print result
            System.out.print(printStringIgnorance(text));

            System.out.println();

        t--;}

    }
}