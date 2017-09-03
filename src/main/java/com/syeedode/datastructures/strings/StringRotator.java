package com.syeedode.datastructures.strings;

import org.springframework.util.StringUtils;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 206; Problem 1.9
 * <p>
 * <p>
 * Author: syeedode
 * Date: 5/19/17
 */
public class StringRotator {

    public boolean isRotation(String s1, String s2) {
        if(s2.length() == s1.length() && !StringUtils.isEmpty(s1) &&  !StringUtils.isEmpty(s2)){
            String s1s1 = s1 + s1;
            return isSubstring(s1s1,s2);
        }
        return false;
    }

    private boolean isSubstring(String s1s1, String s2) {
        int beginIndex = s1s1.indexOf(s2);
        if(beginIndex == -1) return false;
        String substring = s1s1.substring(beginIndex,beginIndex + s2.length());
        return substring.equals(s2);
    }


}
