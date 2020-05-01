package com.debu.uber;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {

    public Deque<Integer> deque;
    public int maxSize;
    public double sumCount;

    public MovingAverage(int size) {
        deque = new LinkedList<>();
        this.maxSize = size;
        this.sumCount = 0;
    }

    public double next(int val) {

        if(deque.size() == maxSize)
        {
            int firstVal = deque.removeFirst();
            sumCount -= firstVal;
        }

        deque.addLast(val);
        sumCount += val;

        return sumCount / deque.size();
    }

    public static void main(String[] args) {
        int size = 3;
        MovingAverage obj = new MovingAverage(size);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
}