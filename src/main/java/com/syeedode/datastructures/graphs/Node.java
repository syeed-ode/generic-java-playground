package com.syeedode.datastructures.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 109, 241; Problem 4.1
 *
 * Breath First Search: BFS
 */
public class Node {
    private final String name;
    private Node[] adjacent;
    private int numberOfAdjacentNodes;
    private GTraversalStateEnum state = GTraversalStateEnum.UNVISITED;

    private Node(String name) {
        this.name = name;
    }

    public void addAdjacent(Node node) {
        if(Objects.isNull(node)) return;

        int length = 1;
        if(Objects.isNull(adjacent)) {
            adjacent = new Node[length];
        }
        if(numberOfAdjacentNodes >= adjacent.length) {
            length = adjacent.length * 2;
            Node[] temp = new Node[length];
            System.arraycopy(adjacent,0,temp,0,numberOfAdjacentNodes);
            adjacent = temp;
        }
        adjacent[numberOfAdjacentNodes] = node;
        numberOfAdjacentNodes++;
    }

    public static Node valueOf(Integer i) {
        Node node = new Node(i.toString());
        node.adjacent = null;
        return node;
    }

    public static Node valueOf(String s) {
        Node node = new Node(s.toString());
        node.adjacent = null;
        return node;
    }

    public static Node valueOf(String n, Node... nodes){
        Node node = new Node(n);
        node.setAdjacent(nodes);
        return node;
    }

    public static Node valueOf(String n, Integer nodeId){
        Node node = new Node(n);
        int pos = 0;
        return node;
    }

    public static Node valueOf(String n, List<Integer> adjacentIds){
        Node node = new Node(n);
        int pos = 0;
        node.adjacent = new Node[adjacentIds.size()];
        for(int ii : adjacentIds) {
            node.adjacent[pos++] = new Node(adjacentIds.toString());
        }
        return node;
    }

    public boolean equals(Node that){
        return this.name.equals(that.getName());
    }

    public int hashCode() {
        return Integer.valueOf(name);
    }

    public String getName() {
        return name;
    }

    public GTraversalStateEnum getState() {
        return state;
    }

    public void setState(GTraversalStateEnum state) {
        this.state = state;
    }

    public Node[] getAdjacent() {
        if(Objects.isNull(adjacent)) return null;

        return adjacent;
    }

    public void setAdjacent(Node[] adjacent) {
        if(Objects.isNull(adjacent))
            return;

        Arrays.asList(adjacent)
                .stream()
                .forEach(node -> addAdjacent(node));
    }

    public int getNumberOfAdjacentNodes() {
        return numberOfAdjacentNodes;
    }
}
