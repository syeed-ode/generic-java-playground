package com.syeedode.datastructures.graphs;

import java.util.LinkedList;
import java.util.Objects;

import static com.syeedode.datastructures.graphs.GTraversalStateEnum.UNVISITED;
import static com.syeedode.datastructures.graphs.GTraversalStateEnum.VISITED;
import static com.syeedode.datastructures.graphs.GTraversalStateEnum.VISITING;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 109, 241; Problem 4.1
 *
 * Breath First Search: BFS
 */

public class GraphSearcher {

    public boolean search(Graph g, Node start, Node end) {
        // Found list
        if(start == end) return true;

        // operates as Queue
        LinkedList<Node> q = new LinkedList<>();

        // initialize list
        for(Node u : g.getNodes()) { u.setState(UNVISITED); }

        start.setState(VISITING);
        q.add(start);

        Node u;

        while (!q.isEmpty()) {
            u = q.removeFirst();

            if(Objects.nonNull(u)) {
                for(Node v : u.getAdjacent()) {
                    if(v.getState().equals(UNVISITED)) {
                        if (verifyFoundNodeElseQueueNode(end, q, v)) return true;
                    } // end if adjacent next hasn't been visited
                } //end for each adjacent next
                u.setState(VISITED);
            }
        } //end while queue is not empty
        return false;
    }

    // Queues next so it we may search it's adjacent next
    private boolean verifyFoundNodeElseQueueNode(Node end, LinkedList<Node> q, Node v) {
        if(v.equals(end)){
            return true;
        } else {
            v.setState(VISITING);
            q.add(v);
        } // end end next not found, but queued and visited
        return false;
    }
}
