package com.syeedode.datastructures.strings;

/**
 * Cracking the Coding Interview
 * Chapter 2: Arrays and Strings
 * pg: , 196; Problem 2.1
 *
 *
 * Author: syeedode
 * Date: 5/18/17
 */
public class OneAwayCalculator {

    public boolean isOneEditAway(String baseString, String comparingString) {
        if(baseString.length() == comparingString.length()) {
            return isOneCharacterEdited(baseString,comparingString);
        } else if (baseString.length() + 1 == comparingString.length()) {
            return isOneEditAwayByInsert(baseString, comparingString);
        } else if (baseString.length() - 1 == comparingString.length()) {
            return isOneEditAwayByInsert(comparingString,baseString);
        }
        return false;
    }

    private boolean isOneEditAwayByInsert(String shorterString, String longerString) {
        int shorterStringIndex = 0, longerStrIndex = 0;
        while(longerStrIndex < longerString.length() &&
                shorterStringIndex < shorterString.length()) {
            if(shorterString.charAt(shorterStringIndex) != longerString.charAt(longerStrIndex)){
                if(shorterStringIndex != longerStrIndex) {
                    return false;
                }
                longerStrIndex++;
            } else {
                longerStrIndex++;
                shorterStringIndex++;
            }
        }
        return true;
    }

    private boolean isOneCharacterEdited(String baseString, String comparingString) {
        boolean foundDifference = false;
        for(int i = 0; i < baseString.length(); i++){
            if(baseString.charAt(i) != comparingString.charAt(i)) {
                if(foundDifference) {
                    return false;
                } else {
                    foundDifference = true;
                }
            }
        }
        return true;
    }

    public boolean isOneEditAwayComplete(String baseString, String comparingString) {
        int baseStringLength = baseString.length();
        int compariingStringLength = comparingString.length();

        // VALIDITY CHECK RETURNS!
        if(Math.abs(baseStringLength - compariingStringLength) > 1) return false;

        String longerString  = baseStringLength > compariingStringLength ? baseString : comparingString;
        String shorterString = baseStringLength < compariingStringLength ? baseString : comparingString;

        int shorterIndex = 0;
        int longerIndex  = 0;

        boolean foundDifference = false;

        while (longerIndex < longerString.length() && shorterIndex < shorterString.length()) {
            if(shorterString.charAt(shorterIndex) != longerString.charAt(longerIndex)) {

                // VALIDITY CHECK RETURNS!
                if(foundDifference) return false;
                // must be the first difference found
                foundDifference = true;


                if(longerString.length() == shorterString.length()) {
                    // found no difference between char index and both
                    // will increment strings are the same length
                    // both shorter string index here (and longer index
                    // outside of loop)
                    // DIFFERENCE WILL BE HANDLED BY `foundDifference`
                    // flag
                    shorterIndex++;
                }
            } else {
                // found no difference between char index will increment
                // both shorter string index here (and longer index
                // outside of loop)
                shorterIndex++;
            }
            longerIndex++;
        } // end while looping through each string
        return true;
    }
}
