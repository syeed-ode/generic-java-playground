package com.syeedode.effectivejava.inheritance.compositionoverinheritance;

import java.util.*;

public class DemoIntrumentedHashSet {
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
            } else if( currentLocation > 0
                    && (!testingList.get(currentLocation - 1).equals(OPPS_MAP.get(String.valueOf(c))))){
                return false;
            } else {
                currentLocation--;
                if(currentLocation > -1) {
                    testingList.remove(currentLocation);
                }
            }

        }
        if(currentLocation > 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        int testCount = 1;
        final String testPattern = "TEST %d - Input: %s - Result: %s";

        final List<String> validInputs = new ArrayList<>();
        validInputs.add("()");
        validInputs.add("([]{}({}))");

        for (String validInput : validInputs)
        {
            System.out.println(String.format(testPattern, testCount, validInput,
                    (isValidParentheses(validInput) ? "PASSED" : "FAILED")));
            testCount++;
        }

        final List<String> invalidInputs = new ArrayList<>();
        invalidInputs.add("(){");
        invalidInputs.add("}");

        for (String invalidInput : invalidInputs)
        {
            System.out.println(String.format(testPattern, testCount, invalidInput,
                    (!isValidParentheses(invalidInput) ? "PASSED" : "FAILED")));
            testCount++;
        }
    }

    private static void executeInstrumentedHashSet() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
    }
}
