package com.syeedode.datastructures.linkedlists;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Cracking the Coding Interview
 * Chapter 2: Linked Lists
 * pg: 92
 */

@RestController
public class LinkedListController {


    @RequestMapping(value = "/linkedList", method = RequestMethod.GET)
    public String linkListAdder(@RequestParam(value = "inputString") String inputString) {

        if(StringUtils.isEmpty(inputString)) return "List is empty";

        return printList(convertStringToNodes(inputString));
    }

    private Node convertStringToNodes(String listOfValues){
        Node node = null;
        for (int a = 1;a <= listOfValues.length(); a++){
            String value = listOfValues.substring(a-1,a);
            Integer i = Integer.valueOf(value);
            if(Objects.isNull(node)){
                node = new Node(i);
            } else {
                node.appendToEnd(i);
            }

        }
        return node;
    }

    private String printList(Node n) {
        if(Objects.isNull(n)) return "List is empty";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(n.getData());
        while(Objects.nonNull(n.getNext())){
            stringBuffer.append("-->"+n.getNext().getData());
            n = n.getNext();
        }

        return stringBuffer.toString();
    }
}
