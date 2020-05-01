package com.debu.Flipkart;

import java.util.Scanner;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Aspire V3 on 13-06-2018.
 */
public class LRUCache {

    private ConcurrentLinkedQueue<Integer> list;
    private ConcurrentHashMap<Integer, Integer> cache;
    Integer maxSize;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    /*Inititalize an LRU list with size N */
    public LRUCache(int N) {
        list = new ConcurrentLinkedQueue<>();
        cache = new ConcurrentHashMap<>(N);
        maxSize = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {

        // first get the read lock
        readLock.lock();

        Integer result = -1;

        try {
            if (cache.contains(x)) {
                // you want to make sure that this index has been accessed recently, hence should be added to the front
                // of the list again. First remove it
                list.remove(x);

                result = cache.get(x);

                //add the cache back to the front
                list.add(x);
            }

        } catch (Exception e) {
            System.out.println("Exception caught while reading cache " + e);
        } finally {
            System.out.println("attempting to release the read lock");
            readLock.unlock();
        }
        return result;
    }

    /*Sets the key x with value y in the LRU list */
    public void set(int x, int y) {

        writeLock.lock();

        try {
            if (cache.contains(x)) {
                list.remove(x);
                cache.remove(x);
            }

            //keep on deleting the cahce rear items till we can add this new item in list
            while (list.size() >= maxSize) {
                Integer index = list.poll();
                cache.remove(index);
            }

            // finally got some room to add the new item both to cache and list
            cache.put(x, y);
            list.add(x);

        } catch (Exception e) {
            System.out.println("Exception caught while setting cache " + e);
        } finally {
            writeLock.unlock();
        }

    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            Set<Integer> s = new HashSet<Integer>();
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while (q > 0) {

                String c = sc.next();
                //	System.out.println(c);
                if (c.equals("GET")) {
                    int x = sc.nextInt();
                    System.out.print(g.get(x) + " ");
                }
                if (c.equals("SET")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    g.set(x, y);
                }

                q--;
                //System.out.println();
            }
            t--;
            System.out.println();
        }
    }
}
