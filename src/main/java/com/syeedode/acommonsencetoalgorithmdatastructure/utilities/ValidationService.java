package com.syeedode.acommonsencetoalgorithmdatastructure.utilities;

import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.LinkedList;
import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.Node;

import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ValidationService {
    private ValidationService(){

    }

    public static final boolean isListInValid(LinkedList list) {
        if(isNull(list) || isNull(list.firstNode)){
            return true;
        }

        return false;
    }

    public static final boolean isNodeValid(Node node) {
        if(nonNull(node) && nonNull(node.data)) {
            return true;
        }

        return false;
    }

    public static boolean validNode(Node node) {
        return Objects.nonNull(node) && Objects.nonNull(node.data);
    }

}
