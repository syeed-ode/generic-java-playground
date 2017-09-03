package com.syeedode.datastructures.trees;

import java.util.Objects;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 100
 */
public class NodeForTree {
    private String name;
    private int data;
    private NodeForTree left;
    private NodeForTree right;

    private NodeForTree() {

    }

    private NodeForTree(Integer i){
        data = i;
        name = String.valueOf(i);
    }

    private NodeForTree(String name, NodeForTree left, NodeForTree right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    /**
     * Cracking the Coding Interview
     * Chapter 4: Trees and Graphs
     * pg: 242, Problem 4.2
     */
    public static NodeForTree createMinimumBSTFromArray(int arr[]){
        if(Objects.isNull(arr)) return null;

        return NodeForTree.createMinimumBSTFromArray(arr,0,arr.length -1);
    }

    public static NodeForTree createMinimumBSTFromArray(int arr[], int start, int end){
        if(end < start) return null;

        if(Objects.isNull(arr)) return null;

        int mid = (start + end) / 2;
        NodeForTree nodeForTree = new NodeForTree(arr[mid]);
        if(Objects.isNull(nodeForTree)) return null;

        nodeForTree.left  = NodeForTree.createMinimumBSTFromArray(arr, mid +1, end);
        nodeForTree.right = NodeForTree.createMinimumBSTFromArray(arr,start,mid -1);
        return nodeForTree;
    }

    public NodeForTree valueOf(String n, NodeForTree l, NodeForTree r){
        return new NodeForTree(n,l,r);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeForTree getLeft() {
        return left;
    }

    public void setLeft(NodeForTree left) {
        this.left = left;
    }

    public NodeForTree getRight() {
        return right;
    }

    public void setRight(NodeForTree right) {
        this.right = right;
    }
}
