package com.debu.array;

import java.util.ArrayList;
import java.util.List;

public class Median2SortedArr {

    private double calculateMedian(List<Integer> m) {

        if (m.size() % 2 == 0) {
            int mid = Math.round(m.size() / 2);

            return (m.get(mid - 1) + m.get(mid)) / 2.0;

        } else {
            return m.get(m.size()/2);
        }

    }

    public double findMedianSortedArrays(int[] arr1, int[] arr2) {

        int len1 = arr1.length;
        int len2 = arr2.length;

        List<Integer> mergedArr = new ArrayList<>(len1 + len2);

        int diff = len1 - len2;

        if (diff < 0) {
            diff = -diff;
        }

        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                mergedArr.add(arr1[i]);
                i++;
            } else {
                mergedArr.add(arr2[j]);
                j++;
            }
        }

        if (i == len1) {
            //second array is more
            while (j < len2) {
                mergedArr.add(arr2[j++]);
            }
        } else {
            while (i < len1) {
                mergedArr.add(arr1[i++]);
            }
        }

        System.out.println(mergedArr);

        return calculateMedian(mergedArr);
    }

    public static void main(String[] args) {

        int[] a1 = {1,3};
        int[] a2 = {2};

        System.out.println(new Median2SortedArr().findMedianSortedArrays(a1, a2));
    }
}
