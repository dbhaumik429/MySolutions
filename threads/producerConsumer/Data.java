package com.debu.threads.producerConsumer;

import java.util.List;
import java.util.Queue;

public class Data {

    private List<List<Integer>> unsorted;
    private List<List<Integer>> sorted;

    public List<List<Integer>> getUnsorted() {
        return unsorted;
    }

    public void setUnsorted(List<List<Integer>> unsorted) {
        this.unsorted = unsorted;
    }

    public List<List<Integer>> getSorted() {
        return sorted;
    }

    public void setSorted(List<List<Integer>> sorted) {
        this.sorted = sorted;
    }
}
