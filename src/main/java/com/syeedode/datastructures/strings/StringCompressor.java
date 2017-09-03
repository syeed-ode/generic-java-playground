package com.syeedode.datastructures.strings;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 201; Problem 1.6
 *
 *
 * Author: syeedode
 * Date: 5/19/17
 */
public class StringCompressor {

    public String compressString(String inputString) {
        int length = inputString.length()
                , consecutiveCharCount = 0
                , newCharCount = 0;
        char [] charArray = new char[length];


        for(int i = 0; i < length; i++) {
            consecutiveCharCount++;
            if((i + 1 == length) || inputString.charAt(i) != inputString.charAt(i + 1)) {
                charArray[newCharCount]   = inputString.charAt(i);
                for(int j = 0; j < String.valueOf(j).length(); j++) {
                    charArray[++newCharCount] = (""+consecutiveCharCount).toCharArray()[j];
                    newCharCount++;
                    if(newCharCount > length){
                        return inputString;
                    }
                }
                consecutiveCharCount = 0;
            }
        }
        return String.valueOf(charArray).trim();
    }

    public String compressBookAnswer(String str) {
        /* Check final length and return input string if it would be longer */
        int finalLength = countCompressionBookAnswer(str);

        if(finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);

        int countConsecutive = 0;

        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    private int countCompressionBookAnswer(String str) {
        int compressedLength  = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, increase the length */
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                int countConsecutiveLength = String.valueOf(countConsecutive).length();
                compressedLength += 1 + countConsecutiveLength;
                countConsecutive = 0;
            }
        }

        return compressedLength;
    }
}
