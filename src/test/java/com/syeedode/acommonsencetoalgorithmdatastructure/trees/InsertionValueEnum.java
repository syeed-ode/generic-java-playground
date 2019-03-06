package com.syeedode.acommonsencetoalgorithmdatastructure.trees;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public enum InsertionValueEnum {

      SEVENTY_FIVE(75)
    , FIFTY_SIX(56)
    , EIGHTY_NINE(89)
    , FIFTY_TWO(52)
    , SIXTY_ONE(61)
    , EIGHTY_TWO(82)
    , NINETY_FIVE(95)
    , TEN(10)
    , THIRTY_THREE(33)
    , FOUR(4)
    , ELEVEN(11)
    , THIRTY(30)
    , FORTY(40)
    ;

    private Integer value;

    InsertionValueEnum(int i) {
        value = i;
    }

    public Integer getValue() {
        return value;
    }

    public InsertionValueEnum valueOf(int i) {
        return Arrays.stream(InsertionValueEnum.values())
                .filter(integer -> integer.getValue().equals(i))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(i + " not valid in insertion enum"));
    }
}
