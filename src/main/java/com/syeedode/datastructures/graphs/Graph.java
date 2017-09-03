package com.syeedode.datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.syeedode.datastructures.graphs.GTraversalStateEnum.*;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 109, 241; Problem 4.1
 * <p>
 * Breath First Search: BFS
 */
public class Graph {
    private Node[] nodes;
    private int numberOfNodes;

    public void addNodeList(List<Node> nodeList) {
        nodeList.stream().forEach(node -> this.addNode(node));
    }

    public void addNode(Node node) {
        int length = 1;
        if(Objects.isNull(nodes)) {
            nodes = new Node[length];
        }
        if(numberOfNodes >= nodes.length) {
            length = nodes.length * 2;
            Node[] temp = new Node[length];
            System.arraycopy(nodes, 0, temp, 0, numberOfNodes);
            nodes = temp;
        }
        nodes[numberOfNodes] = node;
        numberOfNodes++;
    }

    public void addAdjacent(int root, int adjacent) {
        Node foundNode = findNode(root);
    }

    private Node findNode(int nodeId) {
        Node nodeToFind = Node.valueOf(nodeId);
        // operates as Queue
        LinkedList<Node> q = new LinkedList<>();

        clearVisitingFlag();
        nodeToFind.setState(VISITING);

        q.add(nodeToFind);

        Node u;
        while (!q.isEmpty()){
            u = q.removeFirst();

            if(Objects.nonNull(u)){

            } // end if queued item is null
        }
        for(Node n : getNodes()){
            if(n.equals(nodeToFind)) {
                return n;
            }
        }

        return null;
    }

    private void clearVisitingFlag() {
        for(Node u : this.getNodes()) { u.setState(UNVISITED); }
    }

    public void setNodes(Node[] nodes) {
        if(Objects.nonNull(nodes)){
            addNodeList(Arrays.asList(nodes));
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }
}
