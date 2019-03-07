package com.syeedode.effectivejava.inheritance.nestedclasses;

import java.util.*;

public class AnonymousClasses {

    // Concrete implementation built atop skeletal implementation
    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null)
            throw new NullPointerException();
        return new AbstractList<Integer>() {
            public Integer get(int i) {
                return a[i]; // Autoboxing (Item 5)
            }
            @Override public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val; // Auto-unboxing
                return oldVal; // Autoboxing
            }
            public int size() {
                return a.length;
            }
        };
    }
    private static final List<String> OPEN_CHARS = Arrays.asList("{","[","(");
    private static final Map<String, String> OPPS_MAP = new HashMap<>();

    static {
        OPPS_MAP.put("}","{");
        OPPS_MAP.put("]","[");
        OPPS_MAP.put(")","(");
    }

    public static boolean isValidParentheses(String input)
    {
        // START CODING BELOW
        int currentLocation = 0;
        List<String> testingList = new ArrayList<>();
        for(char c : input.toCharArray()) {
            if(OPEN_CHARS.contains(String.valueOf(c))){
                testingList.add(String.valueOf(c));
                currentLocation++;
            } else if(!testingList.get(currentLocation - 1).equals(OPPS_MAP.get(String.valueOf(c)))){
                return false;
            } else {
                testingList.remove(currentLocation);
                currentLocation--;
            }

        }
        return true;
    }
}
