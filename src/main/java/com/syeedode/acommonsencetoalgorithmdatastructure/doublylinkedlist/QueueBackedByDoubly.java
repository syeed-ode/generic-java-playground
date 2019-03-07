package com.syeedode.acommonsencetoalgorithmdatastructure.doublylinkedlist;

public class QueueBackedByDoubly<T> {
    private DoublyLinkedList<T> queue = new DoublyLinkedList<>();

    public void enqueue(T value) {
        queue.insertAtEndOfDoublyLinkedList(value);
    }

    public NodeForDoubly<T>  dequeue() {
        NodeForDoubly<T> removedNode = queue.removeFromFrontOfDoublyLinkedList();
        return removedNode;
    }

    public T tail() {
        return queue.getLastNode().data;
    }
}
