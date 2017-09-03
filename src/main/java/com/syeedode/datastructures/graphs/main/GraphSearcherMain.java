package com.syeedode.datastructures.graphs.main;

import com.syeedode.datastructures.graphs.Graph;
import com.syeedode.datastructures.graphs.Node;

import java.util.LinkedList;
import java.util.Objects;

import static com.syeedode.datastructures.graphs.GTraversalStateEnum.UNVISITED;
import static com.syeedode.datastructures.graphs.GTraversalStateEnum.VISITED;
import static com.syeedode.datastructures.graphs.GTraversalStateEnum.VISITING;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 109, 241; Problem 4.1
 * <p>
 * Breath First Search: BFS
 */
public class GraphSearcherMain {
    public static void main(String[] args) {
        Graph g = GraphSearcherMain.valueOf();
        Node[] n = g.getNodes();
        Node beginNode = n[0];
        Node endNode   = n[6];

        System.out.println("\n\nThere is"
                +  (search(g,beginNode,endNode) ? " a connection " : " no connection " )
                + "between these two nodes.");
    }

    public static Graph valueOf() {
        Graph g = new Graph();
        Node[] temp = new Node[7];
        temp[0] = Node.valueOf("a", 3);
        temp[1] = Node.valueOf("b", 0);
        temp[2] = Node.valueOf("c", 0);
        temp[3] = Node.valueOf("d", 1);
        temp[4] = Node.valueOf("e", 1);
        temp[5] = Node.valueOf("f", 0);
        temp[6] = Node.valueOf("g", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        temp[2].addAdjacent(temp[6]);
        for (int i = 0; i < temp.length; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static boolean search(Graph graph, Node start, Node end) {

        if(Objects.isNull(start) || Objects.isNull(end)) return false;

        if(start.equals(end)) return true;

        LinkedList<Node> q = new LinkedList<>();

        // Initialize state

        start.setState(VISITING);
        q.add(start);
        Node u;

        while(!q.isEmpty()) {
            u = q.removeFirst();
            if(Objects.nonNull(u)) {
                if(Objects.nonNull(u.getAdjacent())) {
                    for(Node adjacentNode : u.getAdjacent()) {
                        if(Objects.nonNull(adjacentNode)){
                            if(adjacentNode.getState().equals(UNVISITED)) {
                                if(adjacentNode.equals(end)) {
                                    return true;
                                } else {
                                    adjacentNode.setState(VISITING);
                                    q.add(adjacentNode);
                                }
                            }
                        }
                    }
                    u.setState(VISITED);
                }
            }
        }
        return false;
    }

}
