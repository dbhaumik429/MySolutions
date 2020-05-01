package com.debu.threads.producerConsumer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class QueueApp {




    Producer producer;
    Consumer consumer;

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i <5; ++i)
        {
           // executorService.submit(producer, );
        }

    }
}
