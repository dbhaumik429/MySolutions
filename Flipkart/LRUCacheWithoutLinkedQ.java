package com.debu.Flipkart;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Aspire V3 on 21-03-2019.
 */
public class LRUCacheWithoutLinkedQ {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Map<Integer, Node> map;
    int maxSize;
    int currCapactiy;

    Node front;
    Node rear;

    /*Inititalize an LRU cache with size N */
    public LRUCacheWithoutLinkedQ(int N) {
        map = new HashMap<>(N);
        maxSize = N;
        front = null;
        rear = null;
        currCapactiy = 0;

    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {

        Integer result = -1;

        try {
            if (map.get(x) != null) {
                // you want to make sure that this index has been accessed recently,
                // hence should be added to the front
                // of the cache again. First remove it
                Node item = map.get(x);

                //remove it
                Node prevTemp = item.prev;
                Node nextTemp = item.next;

                if (prevTemp != null) {
                    prevTemp.next = nextTemp;

                }

                if (nextTemp != null) {
                    nextTemp.prev = prevTemp;
                }

                result = item.value;
                //add to front
                addtoFront(x, item);

                return result;
            } else {

                System.out.println("No such element present in the cache");
            }

        } catch (Exception e) {
            System.out.println("Exception caught while reading data " + e);
        }

        return result;
    }

    private void addtoFront(int x, Node item) {

        if (front == null) {
            front = item;
        } else {
            front.prev = item;
            item.next = front;
        }

        front = item;

        map.put(x, item);
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {


        try {
            if (map.get(x) != null) {
                Node item = map.get(x);
                addtoFront(x, item);
            } else {
                // first check the capacity of the list

                if (currCapactiy == maxSize) {
                    //delete the rear
                    rear = rear.prev;
                    map.remove(rear.key);
                    currCapactiy--;
                }

                Node item = new Node(x, y);
                addtoFront(x, item);
                currCapactiy++;

            }
        } catch (Exception e) {
            System.out.println("Exception caught while setting data " + e);
        }

    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of test cases ");
        int t = sc.nextInt();
        while (t > 0) {
            Set<Integer> s = new HashSet<Integer>();

            System.out.println("Enter the cache size");
            int n = sc.nextInt();
            LRUCacheWithoutLinkedQ g = new LRUCacheWithoutLinkedQ(n);

            System.out.println("enter the number of queries");
            int q = sc.nextInt();

            while (q > 0) {

                System.out.println("Enter the query: Either GET or SET");
                String c = sc.next();
                //	System.out.println(c);
                if (c.equals("GET")) {
                    System.out.println("You chose GET: Enter key");
                    int x = sc.nextInt();
                    System.out.print(g.get(x) + " ");
                }
                if (c.equals("SET")) {
                    System.out.println("You chose SET: Enter key");
                    int x = sc.nextInt();
                    System.out.println("Good, Now enter the value");

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
