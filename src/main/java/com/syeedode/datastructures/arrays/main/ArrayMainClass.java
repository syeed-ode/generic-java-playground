package com.syeedode.datastructures.arrays.main;

import com.syeedode.datastructures.arrays.ArrayUniqStrCalculator;
import com.syeedode.datastructures.arrays.StringComparator;

import static com.syeedode.datastructures.arrays.StringComparator.palendrome;
import static com.syeedode.datastructures.arrays.StringComparator.permutation;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 192; Problem 1.1
 *
 */
public class ArrayMainClass {

    public static void main(String [] args) {
        System.out.println(
                ArrayUniqStrCalculator
                        .reverseString("hey you smoothie"));

        System.out.println("\n\n\n\n\n");

        System.out.println(
                ArrayUniqStrCalculator
                        .calculateUniqString("hey you smoothie"));

        System.out.println("\n\n\n\n\n");

        System.out.println(permutation("xyz","xyy") ? "String matches" : "String doesn't match");

        String string1 = "ri1ck";
        String string2 = "kc1ir";
        System.out.print(palendrome(string1,string2));

        System.out.println("\n\n\n\n\n");

        System.out.println(StringComparator.urlifyString("Mr John Smith    ",13));
    }

}
