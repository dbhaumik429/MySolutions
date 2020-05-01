package com.debu.uber;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    public Map<String, Integer> messageMap;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        messageMap = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        Integer lastTime = messageMap.get(message);

        if (lastTime != null) {
            if (Math.abs(timestamp - lastTime) < 10)
                return false;
        }

        //record the last time when it was put
        messageMap.put(message, timestamp);
        return true;
    }

    public static void main(String[] args) {
        LoggerRateLimiter loggerRateLimiter = new LoggerRateLimiter();
        System.out.println(loggerRateLimiter.shouldPrintMessage(1, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(2, "bar"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(3, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(8, "bar"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(10, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(11, "foo"));
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */