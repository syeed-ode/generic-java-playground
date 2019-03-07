package com.syeedode.acommonsencetoalgorithmdatastructure.trees;

import java.util.Objects;

public class NodeInTree<T extends Comparable<T>> {
    public T data;
    public NodeInTree<T> left;
    public NodeInTree<T> right;

    public NodeInTree(T dataValue, NodeInTree<T> leftSide, NodeInTree<T> rightSide) {
        data = dataValue;
        left = leftSide;
        right = rightSide;
    }

    public NodeInTree() {}

    @Override
    public String toString() {
        String dataValue = getDataValue(data);
        return "NodeInTree@" + "[" + dataValue
                + ", left=" + ((Objects.isNull(left)) ? "null" : getDataValue(left.data))
                + ", right=" + ((Objects.isNull(right)) ? "null" : getDataValue(right.data))
                + "]";
    }

    private String getDataValue(T data) {
        String dataValue;
        if(data instanceof String){
            dataValue =  (String) data;
        } else if (data instanceof Integer) {
            dataValue = String.valueOf((Integer) data);
        }
        dataValue= data.toString();
        return dataValue;
    }
}
