package com.debu.Google;

import javafx.util.Pair;

import java.util.*;

/*
* equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

* */

/*
 *
 * a/b = 2
 *  a= 2b
 *
 *  b = 0.5a
 *
 *  b/c = 3
 *  b = 3c
 *
 *  c = 1/3 b
 *
 *  a -> 2b
 *  b -> 0.5a, 3c
 *  c -> 1/3 b
 *
 *  a / c == same term . b, cancel
 *
 *  b / a ==
 *
 *  a/e = -1
 *
 *  a/a -> same op1 and op2 -> return 1
 *
 *  x/x --> return -1
 *
 *  Pair - value
 *  a,b -
 *
 * b, a -
 *
 *
 *
 * */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<Pair<String,String>, Double> operandsValueMap = new HashMap<>();

        for(int i=0; i<equations.size(); ++i)
        {
            List<String> operands = equations.get(i);
            String op1 = operands.get(0);
            String op2 = operands.get(1);

            Pair<String,String> ops = new Pair<>(op1,op2);

            Double d = new Double(values[i]);

            operandsValueMap.putIfAbsent(ops,d);

        }

        for(int i=0; i<queries.size(); ++i)
        {
            List<String> operands = queries.get(i);
            String op1 = operands.get(0);
            String op2 = operands.get(1);

            Pair<String,String> ops = new Pair<>(op1,op2);


        }

        return null;

    }
    public static void main(String[] args) {

       // System.out.println(new EvaluateDivision().calcEquation([ ["a", "b"], ["b", "c"] ], ));
    }
}
