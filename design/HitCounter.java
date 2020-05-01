package com.debu.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HitCounter {
/*
    private class HitMap {
        Integer time;
        Integer count;
    }*/

    Map<Integer, Integer> timeStampMap;
    //HitCounter.HitMap hitMap;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {

        timeStampMap = new HashMap<>();
        //hitMap = new HitCounter.HitMap();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {

        Integer count = timeStampMap.get(timestamp);

        if (count != null) {
            timeStampMap.put(timestamp, ++count);
        } else {
            timeStampMap.put(timestamp, 1);
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {

        int startTime = 1;

        if (timestamp > 300) {
            startTime = timestamp - 299;
        }

        int hitCount = 0;

        //assuming it has only one entry
        //Integer lastHitTime = hitMap.time;
        Integer diffTime = startTime;
        Integer lastHit = 0;

       /* if (lastHitTime != null) {
            if (startTime > lastHitTime) {
                lastHit = hitMap.count;
                diffTime = timestamp - lastHitTime;
            }

        }
*/
        //store the last hit vs the timestamp - need a map
        while (diffTime <= timestamp) {
            Integer hC = timeStampMap.get(diffTime);
            if (hC != null) {
                hitCount += hC;
            }
            ++diffTime;
        }

        //hitCount += lastHit;

       /* hitMap.time = timestamp;
        hitMap.count = hitCount;*/

        return hitCount;

    }

    /**
     * Your HitCounter object will be instantiated and called as such:
     * HitCounter obj = new HitCounter();
     * obj.hit(timestamp);
     * int param_2 = obj.getHits(timestamp);
     */

    public static void main(String[] args) {
        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(1);
        obj.hit(1);
        obj.hit(300);
        System.out.println(obj.getHits(300));
/*        obj.hit(300);
        System.out.println(obj.getHits(300));
        System.out.println(obj.getHits(301));*/

    }
}