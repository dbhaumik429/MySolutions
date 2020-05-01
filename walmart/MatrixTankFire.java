package com.debu.walmart;


import javafx.util.Pair;

import java.util.*;

/*
* 2. In a cartesian plane, there are N tanks and M objects placed. Tanks can fire in 4 directions (N, S, E, W). Position of tanks and objects are given as input and are fixed. We have to find a way to give directions to N tanks such that they will not hit any object and any other tanks. If a tank can fire in 2 directions, then a direction whose ASCII code is lesser will be given preference.Example:-
Input :-
N=2
M=3

Position of tanks
(0,0)
(1,1)

Position of Objects
(0,2)
(0,-2)
(-2,0)

https://www.geeksforgeeks.org/walmart-labs-interview-experience/

* */
public class MatrixTankFire {

    private static int[][] initializeMatrix(int[][] mat, Set<Pair<Integer, Integer>> objects, int m, int n) {
        for (int i = -2; i < m; ++i) {
            for (int j = -2; j < n; ++j) {
                mat[i][j] = 0;
            }
        }

        objects.stream().forEach(x -> {

            mat[x.getKey()][x.getValue()] = 1;
        });

        return mat;
    }


    private static void fireTank(int[][] mat, int x, int y, int m, int n) {


    }


    public static void main(String[] args) {

        int m = 5;
        int n = 6;

        int[][] mat = new int[m][n];

        Set<Pair<Integer, Integer>> objects = new HashSet<>();
        objects.add(new Pair<>(0, 0));
        objects.add(new Pair<>(1, 1));
        objects.add(new Pair<>(0, 2));
        objects.add(new Pair<>(0, -2));
        objects.add(new Pair<>(-2, 0));

        initializeMatrix(mat, objects, m, n);

        System.out.println(mat);
    }

}
