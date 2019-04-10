package com.syeedode.acommonsencetoalgorithmdatastructure.graphs;

import java.util.*;

import static java.util.Collections.checkedQueue;

/**
 * software/algorithms/grokkingAlgorithmsAnIllustratedGuide.pdf
 */
public class BFSApp {

    public static void main(String [] args) {
        Map<String, List<String>> graph = new HashMap<>();
        List<String> you = Arrays.asList("alice", "bob", "claire");
        List<String> bob = Arrays.asList("anuj", "peggy");
        List<String> alice = Arrays.asList("peggy");
        List<String> claire = Arrays.asList("thom", "jonny");
        List<String> anuj = new ArrayList<>();
        List<String> peggy = new ArrayList<>();
        List<String> thom = new ArrayList<>();
        List<String> jonny = new ArrayList<>();
        Queue<Map<String, List<String>>> search_queue = new PriorityQueue();
        graph.put("you", you);
        graph.put("bob", you);
        graph.put("alice", you);
        graph.put("claire", you);
        graph.put("anuj", you);
        graph.put("peggy", you);
        graph.put("thom", you);
        graph.put("jonny", you);
        // search_queue.add();
    }

}
