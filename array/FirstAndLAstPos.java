package com.debu.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstAndLAstPos {

    private void binarySearch(int[] nums, Integer target, Integer hi, Integer lo, int[] result) {
        if (hi >= lo) {
            Integer pivot = Math.round((hi - lo) / 2) + lo;

            if (nums[pivot] > target) {
                binarySearch(nums, target, pivot - 1, 0, result);
            } else if (nums[pivot] < target) {
                binarySearch(nums, target, nums.length - 1, pivot + 1, result);
            } else {

                if(result[0] == -1 )
                {
                    result[0]=pivot;
                    result[1]=pivot;
                    binarySearch(nums, target, nums.length - 1, pivot + 1, result);

                }

                if (result[0] > pivot) {
                    result[0] = pivot;

                    binarySearch(nums, target, pivot -1, 0, result);
                }

                if( result[1] < pivot ){
                    result[1] = pivot;
                    binarySearch(nums, target, nums.length - 1, pivot + 1, result);
                }

            }
        }

    }

    private Boolean findElement(int[] nums, int target)
    {
        for(int i=0; i< nums.length; ++i)
        {
            if(nums[i]== target)
            {
                return true;
            }

        }

        return false;
    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};
        if (nums.length > 0 && findElement(nums, target)) {
            binarySearch(nums, target, nums.length, 0, result);
        }

        return result;

    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new FirstAndLAstPos().searchRange(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
