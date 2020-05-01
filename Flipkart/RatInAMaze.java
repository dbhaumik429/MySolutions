package com.debu.Flipkart;

import java.util.*;

/**
 * Created by Aspire V3 on 13-06-2018.
 */

/*
*
Input:
2
4
1 0 0 0 1 1 0 1 0 1 0 0 0 1 1 1
4
1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1

Output:
DRDDRR
DDRDRR DRDDRR
*
* */

public class RatInAMaze {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();

            List<String> res = printPath(a, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }


    public static List<String> printPath(int[][] m, int n) {

        List<String> result = null;

         printPathUtil(m, n, 0, 0, result);

        return result;
    }

    public static boolean printPathUtil(int[][] m, int n, int x, int y, List<String> result) {

        if (x == n - 1 && y == n - 1) {
            //solution found, return the result.
            return true;
        }

        if (x > 0 && y > 0 && x < n && y < n && m[x][y] == 1) {

            // down x,y -> x+1, y
            // right x,y -> x,y+1
            if (printPathUtil(m, n, x + 1, y, result)) {
                result.add("D");
                return true;
            }

            if (printPathUtil(m, n, x, y + 1, result)) {
                result.add("R");
                return true;
            }

        }

        return false;
    }
}
