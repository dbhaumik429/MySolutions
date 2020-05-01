package com.debu.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Given two sorted arrays A and B of size M and N respectively and an element k. The task is to find the element that would be at the k’th position of the final sorted array.

Input:
First line consists of test cases T. First line of every test case consists of 3 integers N, M and K, denoting M number of elements in A, N number of elements in B and kth position element. Second and Third line of every test case consists of elements of A and B respectively.

Output:
Print the element at the Kth position.

Constraints:
1 <= T <= 200
1 <= N, M <= 106
1 <= Ai, Bi <= 106
1 <= K <= N+M

Example:
Input:
1
5 4 5
2 3 6 7 9
1 4 8 10

Output:
6

Explanation:

https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array/0
*
* */


public class Merge2SortedArrListImpl {


    private static int mergeArr(List<Integer> arr1, List<Integer> arr2, int element) {
        int len1 = arr1.size();
        int len2 = arr2.size();

        List<Integer> mergedArr = new ArrayList<>(len1 + len2);

        int diff = len1 - len2;

        if (diff < 0) {
            diff = -diff;
        }

        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            if (arr1.get(i) <= arr2.get(j)) {
                mergedArr.add(arr1.get(i));
                i++;
            } else {
                mergedArr.add(arr2.get(j));
                j++;
            }
        }

        if (diff != 0) {
            if (i == len1) {
                //second array is more
                while (j < len2) {
                    mergedArr.add(arr2.get(j++));
                }
            } else {
                while (i < len1) {
                    mergedArr.add(arr1.get(i++));
                }
            }

        }
        return mergedArr.get(element - 1);

    }

    public static void main(String[] args) {

        /*int k = 5;

        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};*/

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            List<Integer> arr1 = new ArrayList(n);
            List<Integer> arr2 = new ArrayList(m);

            for (int a = 0; a < n; ++a) {
                arr1.add(scanner.nextInt());
            }

            for (int a = 0; a < m; ++a) {
                arr2.add(scanner.nextInt());
            }

            //System.out.println(k + " element is " + mergeArr(arr1, arr2, k));
            System.out.println(mergeArr(arr1, arr2, k));
        }
    }
}
