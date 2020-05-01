package com.debu.DP;


import java.util.*;
import java.lang.*;
import java.io.*;

class MinJump {

    public static Integer findMinJumps(Integer[] arr, Integer step, Integer arrlength) {
        if (step >= arrlength)
            return 0;


        Integer n = arr[step];

        // When nothing is reachable
        // from the given source
        if (n == 0)
            return Integer.MAX_VALUE;

        Integer result = Integer.MAX_VALUE;
        for (Integer i = 1; i <= n; ++i) {
            Integer tempresult = findMinJumps(arr, step + i, arrlength);
            if (tempresult != Integer.MAX_VALUE && tempresult + 1 < result) {
                result = tempresult + 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer t = Integer.parseInt(scanner.next());

        Integer n = Integer.parseInt(scanner.next());

        Integer arr[] = new Integer[n];

        for (Integer i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(scanner.next());
        }

        System.out.println(findMinJumps(arr, 0, n - 1));

    }
}
