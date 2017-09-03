package com.syeedode.datastructures.graphs;

import java.util.LinkedList;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 109, 241; Problem 4.1
 * <p>
 * Breath First Search: BFS
 */
public class Junk {

    public static boolean search(Graph g,Node start,Node end) {
        LinkedList<Node> q = new LinkedList<Node>();
        for (Node u : g.getNodes()) {
            u.setState(GTraversalStateEnum.UNVISITED);
        }
        start.setState(GTraversalStateEnum.VISITING);
        q.add(start);
        Node u;
        while(!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.getState() == GTraversalStateEnum.UNVISITED) {
                        if (v == end) {
                            return true;
                        } else {
                            v.setState(GTraversalStateEnum.VISITING);
                            q.add(v);
                        }
                    }
                }
                u.setState(GTraversalStateEnum.VISITED);
            }
        }
        return false;
    }
}
