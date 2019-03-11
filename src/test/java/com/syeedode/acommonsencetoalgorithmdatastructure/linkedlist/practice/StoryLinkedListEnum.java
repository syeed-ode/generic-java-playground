package com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.practice;

import com.syeedode.interviews.wipro.RomanNumeralEnum;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum StoryLinkedListEnum {
      ONCE("once")
    , UPON("uipon")
    , A("a")
    , TIME("time")
    , THERE("there")
    , WAS("was")
    , HAPPILY("happily")
    , EVERAFTER("everafter")
    , TODAY("today")
    ;

    private final String stringValue;

    StoryLinkedListEnum(String value) {
        this.stringValue = value;
    }

    public String valueOf() {  return this.stringValue;  }

    public static StoryLinkedListEnum from(String string) {
        return Arrays.stream(StoryLinkedListEnum.values())
                .filter(str -> str.valueOf().equalsIgnoreCase(string))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(string + " not valid campaign status"));
    }
}
