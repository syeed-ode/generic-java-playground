package com.syeedode.datastructures.linkedlists;

import java.util.Objects;

/**
 * Cracking the Coding Interview
 * Chapter 2: Linked Lists
 * pg: 92
 */

public class Node {
    private Node next = null;
    private Node prev = null;
    private int data;

    public Node(int d) {
        data = d;
    }

    public void appendToEnd(int dataToAppend) {
        Node end = new Node(dataToAppend);
        Node node = this;
        while (Objects.nonNull(node.next)) {
            node = node.next;
        }
        node.next = end;
    }

    public Node deleteNode(Node head, int d) {
        Node n = head;

        if(n.data == d) {
            return head.next;
        }

        while(n.next != null) {

        }

        return head;
    }

    public int getData() {
        return data;
    }

    protected void setData(int d) {
        data = d;
    }

    public Node getNext() {
        return next;
    }
}
