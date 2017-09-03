package com.syeedode.datastructures.reverse;

import java.util.Objects;

/**
 * Atlassian Coding Interview
 * Date: 20170517
 * Author: Syeed Ode
 */
public class OldSolution {
    private static int length = -1;
    public static class LinkedListNode{
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }

        public boolean equals(LinkedListNode o){
            if(Objects.nonNull(val) && val.equals(o.val)){
                if(Objects.nonNull(next) && next.equals(o.next)){
                    return true;
                } else {
                    return Objects.isNull(o.next);
                }
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

    public static int find(LinkedListNode list, LinkedListNode sublist) {
        int temp = 0;
        while (Objects.nonNull(sublist)) {
            if(list.equals(sublist)) {
                length++;
                if(Objects.isNull(sublist.next)){
                    temp = length;
                    length = -1;
                    return temp;
                }
                find(list.next,sublist.next);
            } else {
                return find(list.next,sublist);
            }
        }
        temp = length;
        length = -1;
        return temp;
    }
}
