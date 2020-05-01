package com.debu.DP;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParanthesis {

    public static Integer findLongestValidParanthesis(String input) throws Exception {

        Integer result = 0;
        Stack<Character> stack = new Stack<>();

        Integer index = 0;
        while (index < input.length()) {

            switch (input.charAt(index)) {

                case '(':
                    stack.push(input.charAt(index));
                    index++;
                    break;
                case ')':
                    if (!stack.empty()) {
                        stack.pop();
                        result += 2; // increment by 2
                    }
                    index++;
                    break;
                default:
                    throw new Exception("wrong input!");
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t-- > 0) {
            // Input the size of the array

            String text = sc.next();
            text += sc.nextLine();

            // Compute and print result
            try {
                System.out.print(findLongestValidParanthesis(text));
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println();
        }
    }
}
