package com.syeedode.datastructures.arrays;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 192; Problem 1.1
 */
public class StringComparator {

    public static boolean permutation(String x, String y) {
        if(x.length() != y.length()) return false;

        int [] letters = new int[128];

        char [] xArray = x.toCharArray();
        for (char c : xArray) {
            letters[c]++;
        }

        for(int i = 0; i < y.length(); i++) {
            int c = (int) y.charAt(i);
            letters[c]--;
            if(letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * pg: 192; Problem 1.2
     */
    public static boolean permutationByUtils(String x, String y) {
        if(StringUtils.isEmpty(x) || StringUtils.isEmpty(y)) return false;


        return sortString(x).equals(sortString(y));
    }

    /**
     * pg: 192; Problem 1.2
     */
    private static String sortString(String str) {
        char[] xAsCharArray = str.toCharArray();
        Arrays.sort(xAsCharArray);
        return new String(xAsCharArray);
    }

    public static boolean palendrome(String x, String y) {
        int length = x.length();

        if(length != y.length()) return false;

        for(int i = 0; i < length/2; i++) {
            if(x.charAt(i) != y.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static String urlifyString(String inputString, int trueLength) {
        int spaceCount = 0, index, i = 0;
        char [] str = inputString.toCharArray();

        for(i = 0; i < trueLength; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;
        if(trueLength < str.length) {
            str[trueLength] = '\0'; //end array
        }

        for(i = trueLength -1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return String.valueOf(str);
    }
}
