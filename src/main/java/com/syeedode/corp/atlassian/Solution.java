package com.syeedode.corp.atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Atlassian Coding Interview
 * Date: 20170517
 * Author: Syeed Ode
 */
public class Solution {
    public static String lookAndSay(String start, int n) {
        for(int i=0;i < n; i++){
            int[] temp = new int[start.length()*2];
            int[] newStartCharArray = new int[start.length()*2];
            int countNumber = 0;
            int index = 0;
            for(int j = 0; j < start.length();j++){
                if(temp[j] == temp[j+1]){
                    countNumber++;
                } else {
                    if(countNumber == 0){
                        newStartCharArray[index] = 1;
                        index++;
                        newStartCharArray[index] = temp[j];
                        index++;
                    } else {
                        newStartCharArray[index] = countNumber;
                        index++;
                        newStartCharArray[index] = temp[j];
                        index++;
                    }
                }
            }
            lookAndSay(String.valueOf(newStartCharArray),i);
        }
        return start;
    }
    public static String convert(long input) {
        loadString();
        StringBuffer stringBuffer = new StringBuffer();
        char [] number = new char [20], temp = new char[20];
        int i = 0;
        while (input > 0){
            number[i] = converter.get(Integer.valueOf((int)input%7)).charAt(0);
            input = input / 7;
            i++;
        }
        char [] result = new char[i+1];
        for(int j = 0; j < i; j++) {
            result[i-j] = number[j];
        }
        return String.valueOf(result).trim();
    }

    private static void loadString() {
        converter.put(0,"0");
        converter.put(1,"a");
        converter.put(2,"t");
        converter.put(3,"l");
        converter.put(4,"s");
        converter.put(5,"i");
        converter.put(6,"n");
    }

    private final static Map<Integer, String> converter = new HashMap();

    private static boolean foundMatch = false;
    private static int length = 0;
    private static LinkedListNode intialSubList = null;
    public static class LinkedListNode{
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }

        public boolean equals(LinkedListNode o){
            if(Objects.nonNull(val) && val.equals(o.val)){
                return true;
            }
            return false;
        }
    }

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }

    public static int findSublistWithinList(LinkedListNode list, LinkedListNode sublist, boolean listStarted, int size) {
        int temp = 0;
        if(!listStarted) {
            intialSubList = sublist;
        }
        while (Objects.nonNull(sublist)) {
            if(Objects.isNull(list)) return length;

            if(list.equals(sublist)) {
                foundMatch = true;
                length++;
                if(Objects.isNull(sublist.next) || (size != 0 && length >= size)){
                    temp = length;
                    length = 0;
                    return temp;
                }
                return findSublistWithinList(list.next,sublist.next, true, size);
            } else if(foundMatch) {
                foundMatch = false;
                length = 0;
                return findSublistWithinList(list.next,intialSubList,true, size);
            } else {
                return findSublistWithinList(list.next,sublist,true, size);
            }
        }
        temp = length;
        length = 0;
        return temp;
    }
}
