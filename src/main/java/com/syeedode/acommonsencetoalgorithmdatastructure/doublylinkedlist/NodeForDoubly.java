package com.syeedode.acommonsencetoalgorithmdatastructure.doublylinkedlist;

import java.util.Objects;

public class NodeForDoubly<T> {
    NodeForDoubly<T> next;
    NodeForDoubly<T> previous;

    T data;

    public NodeForDoubly(T dataValue) {
        this.data = dataValue;
    }

    @Override
    public String toString() {
        return  "[" + data
                + ", next=" + ((Objects.isNull(next)) ? "null" : next.data)
                + ", previous=" + ((Objects.isNull(previous)) ? "null" : previous.data)
                + "]";
    }
}
