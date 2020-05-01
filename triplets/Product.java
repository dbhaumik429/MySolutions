package com.debu.triplets;

import java.util.HashMap;

public class Product {


    // Method to count such triplets
    static int countTriplets(int arr[], int n, int m) {
        // Store all the elements in a set
        HashMap<Integer, Integer> occ = new HashMap<Integer, Integer>(n);
        for (int i = 0; i < n; i++)
            occ.put(arr[i], i);

        int count = 0;

        // Consider all pairs and check for a
        // third number so their product is equal to m
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if current pair divides m or not
                // If yes, then search for (m / arr[i]*arr[j])
                if ((arr[i] * arr[j] <= m) && (arr[i] * arr[j] != 0) && (m % (arr[i] * arr[j]) == 0)) {
                    int check = m / (arr[i] * arr[j]);

                    // Check if the third number is present
                    // in the map and it is not equal to any
                    // other two elements and also check if
                    // this triplet is not counted already
                    // using their indexes
                    if (check != arr[i] && check != arr[j]
                            && occ.containsKey(check) && occ.get(check) > i
                            && occ.get(check) > j)
                        count++;
                }
            }
        }

        // Return number of triplets
        return count;
    }

    // Driver method
    public static void main(String[] args) {
        int arr[] = {1, 4, 6, 2, 3, 8};
        int m = 24;

        System.out.println(countTriplets(arr, arr.length, m));
    }
}

