package com.syeedode.corp.amazon;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Amazon Interview
 * <p>
 * Author: syeedode
 * Date: 5/29/17
 */
public class AnagramSolution {

    public List<Integer> getAnagramIndicesTwo(String haystack, String needle) {
        // VALIDATE INPUT
        if(haystack == null || needle == null) return new ArrayList<>();
        if(haystack.trim() == "" || needle.trim() == "") return new ArrayList<>();
        // START PROCESSING

        String newHay = haystack;
        String newNee = needle;
        Set<Integer> integerList = new HashSet<>();
        int i = 0;
        boolean finished = false;
        while(!finished) {
            i = newHay.indexOf(newNee,i);
            if(i > -1){
                integerList.add(i);
                i++;
            } else {
                finished = true;
            }
        }
        return arrayToList(integerList.toArray());
    }

    private static String uniquChars(String str) {
        Set<String> strings = new HashSet<>();
        for(char a : str.toCharArray()){
            strings.add((""+a).toLowerCase());
        }
        StringBuffer sb = new StringBuffer();
        for(String s : strings){
            sb.append(s);
        }
        return sb.toString();
    }

    private static String sortString(String str) {
        char[] xAsCharArray = str.toCharArray();
        Arrays.sort(xAsCharArray);
        return new String(xAsCharArray);
    }

    public static List arrayToList(Object source) {
        return Arrays.asList(toObjectArray(source));
    }

    public static Object[] toObjectArray(Object source) {
        if (source instanceof Object[]) {
            return (Object[]) source;
        }
        if (source == null) {
            return new Object[0];
        }
        if (!source.getClass().isArray()) {
            throw new IllegalArgumentException("Source is not an array: " + source);
        }
        int length = Array.getLength(source);
        if (length == 0) {
            return new Object[0];
        }
        Class<?> wrapperType = Array.get(source, 0).getClass();
        Object[] newArray = (Object[]) Array.newInstance(wrapperType, length);
        for (int i = 0; i < length; i++) {
            newArray[i] = Array.get(source, i);
        }
        return newArray;
    }
}
