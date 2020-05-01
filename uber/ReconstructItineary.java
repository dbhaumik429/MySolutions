package com.debu.uber;

import java.util.*;

/*
 * * https://leetcode.com/problems/reconstruct-itinerary/
 * */

public class ReconstructItineary {

    public List<String> findItinerary(List<List<String>> tickets) {

        //base case check
        if (tickets == null || tickets.size() == 0)
            return new ArrayList<>();

        // for every airport, we need to maintain a PQ to store the next airports in sorted order
        // new PriorityQueue<String>(String::compareTo);

        Map<String, PriorityQueue<String>> graph = new HashMap<>();


        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>(String::compareTo));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();
        topologicalSort("JFK", graph, result);

        return result;
    }

    private void topologicalSort(String vertex, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> queue = graph.get(vertex);

        while (queue != null && !queue.isEmpty()) {
            String adj = queue.poll();
            topologicalSort(adj, graph, result);
        }
        result.addFirst(vertex);
    }


    public static void main(String[] args) {

        /*
         * [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
         * */

        List<List<String>> lists = Arrays.asList(
                Arrays.asList("JFK", "KUL"),
                Arrays.asList("JFK", "NRT"),
                Arrays.asList("NRT", "JFK"));

        System.out.println(new ReconstructItineary().findItinerary(lists));
    }

}
