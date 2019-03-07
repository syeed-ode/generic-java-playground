package com.syeedode.acommonsencetoalgorithmdatastructure.doublylinkedlist;

import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.Node;

import java.util.Objects;

public class DoublyLinkedList<T> {
    private NodeForDoubly<T> firstNode;
    private NodeForDoubly<T> lastNode;
    private int numberOfNodesInList;

    public DoublyLinkedList(NodeForDoubly<T> first, NodeForDoubly<T> last){
        if(Objects.nonNull(first)) ++numberOfNodesInList;

        if(Objects.nonNull(last)) ++numberOfNodesInList;

        // only equal if at same address location
        if(numberOfNodesInList > 1 && first == last) {
            --numberOfNodesInList;
        }

        this.firstNode = first;
        this.lastNode = last;
    }

    public DoublyLinkedList() {

    }

    public void insertAtEndOfDoublyLinkedList(T dataValue) {
        NodeForDoubly<T> newNode = new NodeForDoubly<>(dataValue);

        if(Objects.isNull(firstNode)) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.previous = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }
        ++numberOfNodesInList;
    }

    public NodeForDoubly<T> removeFromFrontOfDoublyLinkedList() {
        NodeForDoubly<T> removedNode = firstNode;
        firstNode = firstNode.next;
        firstNode.previous = null;
        numberOfNodesInList--;
        return removedNode;
    }

    public NodeForDoubly<T> getFirstNode() {
        return firstNode;
    }

    public NodeForDoubly<T> getLastNode() {
        return lastNode;
    }

    public int getNumberOfNodesInList() {
        return numberOfNodesInList;
    }
}
