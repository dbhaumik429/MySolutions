package com.debu.Google;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        if (m == 0) {
            return;
        }

        int n = matrix[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }


        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                int temp = matrix[n - 1 - j][m - 1 - i];
                matrix[m - 1 - j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }

    public static void main(String[] args) {

        int[][] mat = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

    }
}
