package com.debu.array;

import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Aspire V3 on 31-07-2017.
 */
public class SherlockAndCount {

    public static void main(String args[] )  {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        int testcaseNo = Integer.parseInt(scanner.next());
        int len=Integer.parseInt(scanner.next());

        String arr = scanner.next();

        StringTokenizer st = new StringTokenizer(arr," ");

        List<Integer> list = new ArrayList<>();

        while(st.hasMoreElements())
        {
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println("pratctise to excffellence");
    }
}
