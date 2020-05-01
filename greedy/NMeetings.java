package com.debu.greedy;

import java.util.Arrays;
import java.util.List;

public class NMeetings {

    public static Integer findNumberOfMeetings(List<Integer> start, List<Integer> finish) {


        finish.sort((o1, o2) -> {
            return o1 - o2;
        });

        Integer count = 0;
        Integer en=0;
        for (int i = 0; i < start.size(); ++i) {
            Integer st = start.get(i);

            if (st > en) {
                count++;
                en = finish.get(i);
                System.out.println("start " + st + ", finish " + en);
            }
        }

        return count;

    }

    public static void main(String[] args) {

        List<Integer> start = Arrays.asList(75250,50074,43659,8931,11273,27545,50879,77924);
        List<Integer> finish = Arrays.asList(112960,114515,81825,93424,54316,35533,73383,160252);

        System.out.println(findNumberOfMeetings(start, finish));


    }
}
