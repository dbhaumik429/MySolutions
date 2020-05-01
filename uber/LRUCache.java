package com.debu.uber;

import java.util.*;

public class LRUCache {

    //store the capacity
    int capacity;

    //stores the actual data
    Map<Integer, Integer> data;

    // should store the least recently used at the begining - store the key
    //i should have an ability to remove from last and add at first.
    // how mucj time does the remove operation is taking ?
    Deque<Integer> queue;

    LRUCache(int capa) {
        this.capacity = capa;
        this.data = new HashMap<>(capa);
        this.queue = new LinkedList<>();

    }

    public int get(int key) {
        // a get operation will actually move the item to the begining.
        if (!queue.contains(key)) {
            return -1;
        }

        //find out the key in the queue and remove that
        queue.remove(key);

        // then add it at the begining
        queue.addFirst(key);

        return data.get(key); // return the value
    }

    public void put(int key, int value) {

        // if key exists - update the LRU and return
        if (queue.contains(key)) {
            data.put(key, value);
            queue.remove(key);
            queue.addFirst(key);
            return;
        }


        if (data.size() == capacity) {
            // that means it is full
            int lastKey = queue.removeLast();
            data.remove(lastKey);
        }

        queue.addFirst(key);
        data.put(key, value);

    }


    public static void main(String[] args) {
/*
* ["LRUCache","put","put","get","get","put","get","get","get"]
[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
* */

        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(2, 1);
        cache.put(3, 2);
        cache.get(3);       // returns 1
        cache.get(2);    // evicts key 2
        cache.put(4, 3);    // evicts key 1
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
        cache.get(2);       // returns 4
        cache.get(1);       // returns 4
        cache.get(4);       // returns 4
        cache.get(42);       // returns 4
        cache.get(3);       // returns 4
        cache.put(4, 3);    // evicts key 1
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.put(4, 3);    // evicts key 1
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.put(4, 3);    // evicts key 1
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.put(1, 10);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.put(4, 3);    // evicts key 1
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.put(2, 10);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.put(2, 100);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4
        cache.get(4);       // returns 4


    }
}
