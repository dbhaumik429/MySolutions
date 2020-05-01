package com.debu.DP;

import java.util.*;
import java.lang.*;
import java.io.*;


public class SubsetSum {

    public static String isComibinationPossible(int[] arr, int n) {

        Arrays.sort(arr);
        int remaining = arr[n - 1];
        int index = 0;

        while (remaining > 0) {
            remaining -= arr[index];
            index++;

            if (remaining == 0)
                return "YES";
        }

        return "NO";
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(isComibinationPossible(arr, n));

            t--;
        }


    }

}