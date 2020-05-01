package com.debu.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aspire V3 on 01-09-2017.
 */
public class kthSmallestMultTable {

    static int findKthSmallestElement(int [][] mat, int k, int m, int n)
    {
        List arr = new ArrayList();

        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                arr.add(mat[i][j]);
            }
        }

        Collections.sort(arr);

        return (int)arr.get(k-1);
    }

    static int count(int v, int m, int n) {
        int count1 = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i , n);
            count1 += temp;
        }
        return count1;
    }

    static public int findKthNumber(int m, int n,int k) {
        int low = 1 , high = m * n + 1;

        while (low < high) {

            int mid = low + (high - low) / 2;
            int c = kthSmallestMultTable.count(mid, m, n);

            if (c >= k)
                high = mid;
            else
                low = mid + 1;
        }

        return high;
    }

    static int[][] createMultiplicationTable(int m,int n)
    {
        int[][] mat = new int[m][n];

        for(int i=0;i<n;++i)
            mat[0][i]=i+1;

        for(int i=0;i<m;++i)
            mat[i][0]=i+1;

        for(int i=1;i<m;++i)
        {
            for(int j=1;j<n;++j)
            {
                mat[i][j]=mat[0][j]*mat[i][0];
            }
        }

        return mat;
    }

    static void printMatrix(int[][] mat,int m, int n)
    {
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        int m=2,n=2;
        int k=3;
        System.out.println(findKthNumber(m,n,k));

        /*
        int[][] mat = createMultiplicationTable(m,n);
        printMatrix(mat,m,n);
        System.out.println(findKthSmallestElement(mat,k,m,n));
        */
    }
}
