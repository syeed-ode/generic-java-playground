package com.syeedode.datastructures.arrays;

import org.springframework.util.StringUtils;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 192; Problem 1.1
 */
public class ArrayUniqStrCalculator {

    private ArrayUniqStrCalculator() {

    }

    public static ArrayUniqStrCalculator valueOf() {
        return new ArrayUniqStrCalculator();
    }

    public static String reverseString(String str) {
        if(StringUtils.isEmpty(str)) return null;

        char [] arr  = str.toCharArray();
        int length = arr.length;
        char [] temp = new char[length];
        char temp2;
        for(int i = 0; i < length/2; i++) {
            temp2 = arr[i];
            arr[i] = arr[length-1-i];
            arr[length-1-i] = temp2;
        }
        return String.valueOf(arr);
    }

    public static boolean calculateUniqString(String str) {
        if(StringUtils.isEmpty(str)) return true;

        int length = str.length();

        // ONLY IF ASCII
        if(length > 128) return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < length; i++){
            int val = str.charAt(i);
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
