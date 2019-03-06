package com.syeedode.acommonsencetoalgorithmdatastructure.trees;

public enum  StringInsertionEnum {
      MOBY("Moby Dick")
    , GREAT("Great Expectations")
    , ROBBY("Robinson Crusoe")
    , ALICE("Alice In Wonderland")
    ;

    private String value;

    StringInsertionEnum(String s) {
        value = s;
    }

    public String valueOf() {
        return value;
    }
}
