package com.syeedode.interviews.wipro;


import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DemoRomanNumeralConversion {

    private static final Map<String, Integer> ROMAN_TO_DECIMAL_MAP = new HashMap<>();

    static {
        ROMAN_TO_DECIMAL_MAP.put("I",1);
        ROMAN_TO_DECIMAL_MAP.put("V",5);
        ROMAN_TO_DECIMAL_MAP.put("X",10);
        ROMAN_TO_DECIMAL_MAP.put("L",50);
        ROMAN_TO_DECIMAL_MAP.put("C",100);
        ROMAN_TO_DECIMAL_MAP.put("D",500);
        ROMAN_TO_DECIMAL_MAP.put("M",1000);
    }

    public static final void main(String args []) {
        System.out.println("Hey");
        int resultValue = getDecimalResultValue(args[0]);
        System.out.println("The decimal value is: " + resultValue);
    }

    public static int getDecimalResultValue(String arg) {
        String programInput = validateInput(arg);
        // XI
        Stack<RomanNumeralEnum> computationStack = new Stack<>();
        int resultValue = 0;
        for(char c : programInput.toCharArray()) {
            String romanNumberalString = validateRomanNumberCharacters(String.valueOf(c));
            Integer currentValue = RomanNumeralEnum.from(romanNumberalString).integerOf();
            if(computationStack.empty()) {
                computationStack.push(RomanNumeralEnum.from(romanNumberalString));
                resultValue += currentValue;
            } else {
                Integer previousValue = computationStack.peek().integerOf();
                if(previousValue >= currentValue){
                    resultValue += currentValue;
                    computationStack.push(RomanNumeralEnum.from(romanNumberalString));
                } else {
                    resultValue -= previousValue;
                    resultValue = resultValue + currentValue - previousValue;
                    computationStack.push(RomanNumeralEnum.from(romanNumberalString));
                }
            }
        }
        return resultValue;
    }

    public static String validateRomanNumberCharacters(String input) {
        if(StringUtils.isEmpty(input) || !ROMAN_TO_DECIMAL_MAP.containsKey(input.trim())){
            System.out.println("Not a valid roman numeral character");
            System.exit(0);
        }
        return input;
    }

    public static String validateInput(String input) {
        if(StringUtils.isEmpty(input)){
            System.out.println("Invalid input");
            System.exit(0);
        }
        return input;
    }
}
