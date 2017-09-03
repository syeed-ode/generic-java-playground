package com.syeedode.datastructures.strings.palindrome;

/**
 * Cracking the Coding Interview
 * Chapter 2: Arrays and Strings
 * pg: 196; Problem 2.1
 *
 * Author: syeedode
 * Date: 5/18/17
 */
public class Palindrome {

    public boolean isPermuationOfPalindrome(String phrase) {
        int [] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public boolean isPermutationOfPalindromeOddCount(String phrase) {
        int countOdd = 0;
        int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
                if(table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private int[] buildCharFrequencyTable(String inputPhrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char c : inputPhrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    /*
     *  Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
     *  This is case INsensitive. Non-letter characters map to -1.
     *  getNumericValue maps case insensitive number
     */
    private int getCharNumber(char inputChar) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(inputChar);
        if(a <= val &&  val <= z) {
            return val - a;
        }
        return -1;
    }

    private boolean checkMaxOneOdd(int[] characterTable) {
        boolean foundOdd = false;
        for (int count : characterTable) {
            if (count % 2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
}
