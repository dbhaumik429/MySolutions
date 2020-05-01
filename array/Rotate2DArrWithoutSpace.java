package com.debu.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rotate2DArrWithoutSpace {

    private static void printMatrix(int[][] arr, int n) {
        for (int i = 0; i < n; ++i) {

            for (int j = 0; j < n; ++j) {
                System.out.println(arr[i][j]);
            }
        }
    }

    private static int[][] transpose(int[][] arr, int n) {


        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }

        return arr;

    }

    private static int[][] reverseCol(int[][] arr, int n) {


        for (int i = 0; i < n; ++i) {

            for (int j = 0, k = n - 1; j < k; ++j, --k) {

                int temp = arr[i][j];

                arr[i][j] = arr[i][k];

                arr[i][k] = temp;

            }
        }

        return arr;

    }


    public static void rortateArr(int[][] arr, int n) {

        // row left to right
        arr = transpose(arr, n);
        arr = reverseCol(arr, n);

        printMatrix(arr, n);
    }

   /* public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; ++i) {

                for (int j = 0; j < n; ++j) {
                    arr[i][j] = scanner.nextInt();
                }
            }


            //System.out.println(k + " element is " + mergeArr(arr1, arr2, k));
            rortateArr(arr, n);
        }
    }*/

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]= sc.nextInt();
                }
            }
            for(int i=0;i<n;i++){
                for(int j=n-1;j>=0;j--){
                    System.out.print(a[j][i]+" ");
                }
            }
            System.out.println();
        }
    }
}
