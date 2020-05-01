package com.debu.Google.Array;


import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
 *
 * */
public class FindSumWithTarget {

    private static int find(int[] arr, int k)
    {
        int res=0;

        //will hold the count of prev sum and how many time it has occured
        Map<Integer,Integer> prevSum = new HashMap<>();
        int currSum=0;

        for(int i=0; i< arr.length; ++i)
        {
            currSum += arr[i];
            System.out.println("-->" + currSum);

            if(currSum == k)
            {
                System.out.println("currSum == k ");
                res++;
            }

            // if currSum > k , then what? the means we need to exclude the one which is causing this
            // we need to find the negative value if exisits
            if (prevSum.containsKey(currSum - k)) {
                System.out.println("trying to find " + (currSum - k ) + " in " + prevSum);
                res += prevSum.get(currSum - k);
            }

            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1 );
            System.out.println("prevSum " + prevSum);
        }

        return res;


    }

    public static void main(String[] args) {
//
//        int[] arr = {1, -2, 2, 3};
//        int k = 3;

        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;

        System.out.println(find(arr, k));
    }
}
