package com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;
import java.util.Objects;

public class LinkedList<T> {
    public Node<T> firstNode;
    private int linkedNodeSize;

    public LinkedList(Node<T> node) {
        firstNode = node;
        linkedNodeSize++;
    }

    public static class LinkedListResultSet<T> {
        private Node<T> answerNode;
        private int index;

        private LinkedListResultSet(Node<T> result, int position) {
            answerNode = result;
            index = position;
        }

        public Node<T> getAnswerNode() {
            return answerNode;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "LinkedListResultSet@" + Integer.toHexString(this.hashCode()) + "["
                    + String.valueOf(answerNode) + ", index: " + index + "]";
        }
    }

    public LinkedListResultSet<T> read(int index) {
        Node<T> currentNode = firstNode;
        int currentIndex = 0;

        while (currentIndex < index && Objects.nonNull(currentNode)) {
            currentNode = currentNode.next;
            ++currentIndex;
        }
        if(currentIndex == index) {
            return new LinkedListResultSet(currentNode, currentIndex);
        } else {
            return null;
        }
    }

    public LinkedListResultSet<T> search(T dataItemLookingFor) {
        Node<T> currentNode = firstNode;
        int currentIndex = 0;

        while (Objects.nonNull(currentNode) && currentNode.data != dataItemLookingFor) {
            ++currentIndex;
            currentNode = currentNode.next;
        }
        if(Objects.nonNull(currentNode) && currentNode.data == dataItemLookingFor) {
            return new LinkedListResultSet(currentNode, currentIndex);
        }
        return null;
    }

    public void insertValue(int insertionPosition, T dataValue) {
        if(insertionPosition > linkedNodeSize) {
            insertValue(linkedNodeSize, dataValue);
        }

        Node<T> currentNode = firstNode;
        int currentIndex = 0;

        while(currentIndex < insertionPosition && Objects.nonNull(currentNode.next)) {
            currentNode = currentNode.next;
            ++currentIndex;
        }

        Node<T> newNode = new Node(dataValue);
        // point everything after insertion point to
        // new node
        newNode.next = currentNode.next;

        // insert new node be after the current node
        currentNode.next = newNode;

        // increment the total number of nodes in the
        // linked list
        ++linkedNodeSize;
    }

    public void deleteValue(int index) {
        Node<T> currentNode = firstNode;
        int currentIndex = 0;

        // First, we find the node immediately before the
        // one we want to delete and call it current_node:
        while (currentIndex < index - 1) {
            currentNode = currentNode.next;
            ++currentIndex;
        }

        // This is node that comes after the one we're deleting
        Node<T> nodeAfterDeletingNode = currentNode.next.next;

        // Now change the link of the current_node to point
        // to the nodeAfterDeletingNode, leaving the node we
        // want to delete out of the list:
        currentNode.next = nodeAfterDeletingNode;

        --linkedNodeSize;
    }

    public int numberOfNodesInTheList() {
        return linkedNodeSize;
    }
}
