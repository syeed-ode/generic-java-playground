package com.syeedode.datastructures.graphs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 109, 241; Problem 4.1
 * <p>
 * Breath First Search: BFS
 */

@RestController
public class GraphSearcherController {

    Graph g = new Graph();

    @RequestMapping(value = "/bfs", method = RequestMethod.GET)
    public String doBreathFirstSearch() {
        loadGraph();
        Node node5 = Node.valueOf(5);
        node5.addAdjacent(Node.valueOf(4));
        node5.addAdjacent(Node.valueOf(10));
        node5.addAdjacent(Node.valueOf(20));
        node5.addAdjacent(Node.valueOf(23));
        return "Completed breath first search";
    }

    private void loadGraph() {
        g.addNodeList(
                Arrays.asList(
                          Node.valueOf(5)
                        , Node.valueOf(4)
                        , Node.valueOf(10)
                        , Node.valueOf(20)
                )
        );
    }
}
