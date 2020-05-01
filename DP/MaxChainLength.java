package com.debu.DP;

import java.util.*;
import java.lang.*;

/*
* https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/
*
* */
public class MaxChainLength {

    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            MaxChainLength.Pair pr[] = new Pair[n];
            int arr[] = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0, j = 0; i < 2 * n - 1 && j < n; i = i + 2, j++) {
                pr[j] = new MaxChainLength.Pair(arr[i], arr[i + 1]);
            }
            MaxChainLength g = new MaxChainLength();
            System.out.println(g.maxChainLength(pr, n));
        }
    }

    /*This is a function problem.You only need to complete the function given below*/

    class CompareByFirst implements Comparator<MaxChainLength.Pair> {
        public int compare(MaxChainLength.Pair a, MaxChainLength.Pair b) {
            //sorted by the first number
            return a.x - b.x;
        }
    }


    int maxChainLength(MaxChainLength.Pair arr[], int n) {

        //sort the array according to the first elements.
        Arrays.sort(arr, new CompareByFirst());

        int[] DP = new int[arr.length];
        Arrays.fill(DP, 1);

        for (int i = 1; i < arr.length; ++i) {

            //compare with each element with every other element.
            for(int j=0; j<i;++j) {

                if ((arr[j].y < arr[i].x) && (DP[i] < DP[j] + 1)) {
                    DP[i] = DP[j] + 1;
                }
            }

        }

        int max = DP[0];
        //find the max out of the DP table
        for (int i = 1; i < arr.length; ++i) {
            if (max < DP[i])
                max = DP[i];
        }

        return max;
    }
}

