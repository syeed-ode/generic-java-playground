package com.syeedode.datastructures.strings.main;

import com.syeedode.datastructures.strings.MatrixNullifier;
import com.syeedode.datastructures.strings.MatrixRotator;
import com.syeedode.datastructures.strings.StringCompressor;

import static com.syeedode.datastructures.strings.palindrome.PalindromeService.executePalindrome;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 196; Problem 1.1 - 1.6
 *
 * Author: syeedode
 * Date: 5/18/17
 */
public class StringsMain {
    public static void main(String [] args) {
        executePalindrome();

//        OneAwayCalculator oneAway = new OneAwayCalculator();
//        boolean answer = oneAway.isOneEditAway("ple", "pale");
//        System.out.println(answer);

        StringCompressor stringCompressor = new StringCompressor();
//        String stringOutput = stringCompressor.compressString("aabcccccaaa");
//        stringOutput = stringCompressor.compressString("aaaabbbbbbabbbbabac");
//        String stringOutput = stringCompressor.compressBookAnswer("aabcccccaaa");
//        System.out.println(stringOutput);

        MatrixRotator rotator = new MatrixRotator();
        Integer [][] a = {  { 1, 2, 3, 4}
                          , { 5, 6, 7, 8}
                          , { 9,10,11,12}
                          , {13,14,15,16}
        };
//        Integer [][] a = {  {1,2,3}, {4, 5, 6}};
        rotator.printMatrix(a);
        System.out.println("\n\n\n");
        rotator.printMatrix(rotator.rotate(a));

        MatrixNullifier matrixNullifier = new MatrixNullifier();

//        StringRotator stringRotator = new StringRotator();
//        System.out.println(stringRotator.isRotation("waterbottle","erbottlewat"));

    }

    private static void a() {
    }
}
