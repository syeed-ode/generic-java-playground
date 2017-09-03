package com.syeedode.datastructures.bigO.spacial;

import org.springframework.stereotype.Service;

/**
 * Cracking the Coding Interview
 * Chapter 5: Big O
 * pg: 44, bottom
 */

@Service
public class SpacialComplexityService {
    private String position = new String();
    private String tabs = new String();

    public String createSumAndPrintValue(int n){
        sum(n);
        System.out.print(position);
        return position;
    }

    private int sum(int n) {
        addPosition(n);
        if(n > 0) {
            return n + sum(n -1);
        }
        return 0;
    }

    private void addPosition(int n) {
        position = new StringBuffer(position + "sum(" + n + ")" + "\n" + addTabs()).toString();
    }

    private String addTabs(){
        return tabs + "<PRE>";
    }
}
