package com.debu.facebook;


import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
*
*
* https://leetcode.com/problems/task-scheduler/
*
* 621. Task Scheduler
Medium

1688

287

Favorite

Share
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.



Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
*
* */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> jobMap = new HashMap<>();

        for (int i = 0; i < tasks.length; ++i) {

            jobMap.putIfAbsent(Character.valueOf(tasks[i]), 1 );
            Integer count = jobMap.get(Character.valueOf(tasks[i]));
            jobMap.put(Character.valueOf(tasks[i]), ++count);

        }

        for(Map.Entry<Character,Integer> entry : jobMap.entrySet())
        {
            Character job = entry.getKey();

            entry.getValue();
        }
return 0;
    }

    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        System.out.println(new TaskScheduler().leastInterval(tasks, n));

    }
}
