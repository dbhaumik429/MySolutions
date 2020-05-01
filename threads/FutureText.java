package com.debu.threads;

import org.w3c.dom.ranges.Range;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by Aspire V3 on 08-06-2017.
 */
public class FutureText {

    static Integer factorial(int number) throws InterruptedException
    {
        int res = 1;
        while(number>0)
        {
            res *= number;
            --number;
            TimeUnit.SECONDS.sleep(1);
        }

        return res;
    }

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> fut = executorService.submit(() -> {

            try
            {
                return factorial(10);
            }catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            return 0;
        });

        executorService.submit(() -> {
            IntStream.range(1,10).forEach( i -> {
                                                    System.out.println(i);
                                            });
        });

        try
        {
            System.out.println("result = " + fut.get());
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


        executorService.shutdown();

    }
}
