package com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.practice;

import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.LinkedList;
import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.Node;

import static com.syeedode.acommonsencetoalgorithmdatastructure.utilities.ValidationService.*;
import static java.util.Objects.nonNull;

public class SubListContainsLinkedList<T extends Comparable<T>> extends LinkedList{

    public SubListContainsLinkedList(Node node) {
        super(node);
    }

    public boolean isSubList(LinkedList<T> subList){
        boolean foundMatch = false;
        Node<T> currentNode = firstNode;
        Node<T> currentNodeForOuterLoop = firstNode;
        Node<T> currentSubnode = subList.firstNode;
        while(validNode(currentNode)){
            while (validNode(currentSubnode)) {
                if(currentNode.data.equals(currentSubnode.data)) {
                    currentNode = currentNode.next;
                    currentSubnode = currentSubnode.next;
                    foundMatch = true;
                } else {
                    foundMatch = false;
                    break;
                }
            }
            if(foundMatch) {
                break;
            }
            currentNode = currentNodeForOuterLoop.next;
            currentNodeForOuterLoop = currentNodeForOuterLoop.next;
            currentSubnode = subList.firstNode;
        }
        return foundMatch;
    }
}
