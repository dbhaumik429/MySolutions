package com.debu.uber;

import java.util.HashMap;
import java.util.Map;

public class HitCounter {

    Map<Integer, Integer> timeStampMap;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {

        timeStampMap = new HashMap<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {

        timeStampMap.putIfAbsent(timeStampMap.get(timestamp), 0);
        Integer count = timeStampMap.get(timestamp);
        timeStampMap.put(timestamp, ++count);
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

        //store the last hit vs the timestamp - need a map
        while (diffTime <= timestamp) {
            Integer hC = timeStampMap.get(diffTime);
            if (hC != null) {
                hitCount += hC;
            }
            ++diffTime;
        }

        return hitCount;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
