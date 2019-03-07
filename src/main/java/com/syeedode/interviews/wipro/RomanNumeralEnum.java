package com.syeedode.interviews.wipro;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum  RomanNumeralEnum {
        ONE("I",1),
        FIVE("V",5),
        TEN("X",10),
        FIFTY("L",50),
        ONE_HUNDRED("C",100),
        FIVE_HUNDRED("D",500),
        ONE_THOUSAND("M",1000);

    private final String romanNumeral;
    private final Integer integer;

    RomanNumeralEnum(String romanNumeral, Integer integer) {
        this.romanNumeral = romanNumeral;
        this.integer = integer;
    }

    public String valueOf(){
        return this.romanNumeral;
    }
    public Integer integerOf() { return this.integer; }

    public static RomanNumeralEnum from(String string) {
        return Arrays.stream(RomanNumeralEnum.values())
                .filter(str -> str.valueOf().equalsIgnoreCase(string))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(string + " not valid campaign status"));
    }
}
