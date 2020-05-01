package com.debu.string;

// A Sample Java program for beginners with Competitive Programming

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

public class secondMostRepeated {

    // This function returns index of element x in arr[]
    static String search2ndMost(String arr[], int n) {
        if (arr.length == 0) {
            return "";
        }

        Map<String, Integer> charMap = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            if (charMap.get(arr[i]) == null) {
                charMap.put(arr[i], 1);
            } else {
                int freq = charMap.get(arr[i]);
                charMap.put(arr[i], ++freq);
            }
        }

        Integer first_max = Integer.MIN_VALUE;
        Integer sec_max = Integer.MIN_VALUE;

        Iterator<Map.Entry<String, Integer>> itr = charMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if (v > first_max) {
                sec_max = first_max;
                first_max = v;
            } else if (v > sec_max && v != first_max)
                sec_max = v;
        }

        final Integer val = sec_max;
        List<String> list = charMap.entrySet().stream().filter(entry -> entry.getValue() == val).map(Map.Entry::getKey).collect(Collectors.toList());
        return list.get(0);
    }

    public static void main(String[] args) {
        // Note that size of arr[] is considered 100 according to
        // the constraints mentioned in problem statement.
        String[] arr = new String[1000];

        Vector<String> v = new Vector<>();
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t-- > 0) {
            // Input the size of the array
            int n = sc.nextInt();

            // Input the array
            for (int i = 0; i < n; i++)
                arr[i] = sc.next();

            // Compute and print result
            System.out.println(search2ndMost(arr, n));

        }
    }
}

