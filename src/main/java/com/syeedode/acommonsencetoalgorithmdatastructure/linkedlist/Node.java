package com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist;

public class Node<T> {
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String dataValue;
        if(data instanceof String){
            dataValue =  (String) data;
        } else if (data instanceof Integer) {
            dataValue = String.valueOf((Integer) data);
        }
        dataValue= data.toString();

        return "Node@" + Integer.toHexString(hashCode()) + "[" + dataValue
                + ", next=" + next
                + "]";
    }
}
