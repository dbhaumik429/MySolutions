package com.debu.threads.producerConsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Producer implements Runnable{

    private Integer producerName;
    private Lock lock;

    private Data data;

    @Override
    public void run() {

        System.out.println("producer running");

        Integer cnt=10;
        for(int i=0; i<100; ++i)
        {
            while(cnt-- > 0)
            {
                double rand =  Math.random() % 1000;

               // lock = new ReentrantReadWriteLock();


                try{

                    data.getUnsorted();


                }catch(Exception e)
                {

                }finally {
                    //reentrantReadWriteLock.
                }
            }

        }
    }

    public Integer getProducerName() {
        return producerName;
    }

    public void setProducerName(Integer producerName) {
        this.producerName = producerName;
    }
}
