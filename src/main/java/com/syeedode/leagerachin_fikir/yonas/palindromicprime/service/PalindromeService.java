package com.syeedode.leagerachin_fikir.yonas.palindromicprime.service;

/**
 *  Notice that there is a class to do each operation.
 *
 *  Every class should have only one area of responsibility.
 *
 *  Small classes that do one thing is the best way to code.
 */

/**
 * The sole purpose of this class is to determine if an
 * Integer is a palindrome. That's it. It does nothing else.
 */
public class PalindromeService {

    public boolean isNumberAPalindrome(int numberInQuestion) {
        String numberAsAString = String.valueOf(numberInQuestion);
        int stringLength = numberAsAString.length();
        if(stringLength == 1) {
            return true;
        }
        return isPalindrome(numberAsAString, stringLength);
    }

    private boolean isPalindrome(String string, int length) {
        boolean isPalindrome = true;
        int i = 0;
        while (i < length / 2) {
            int compareToChar = length - i -1;
            if(string.charAt(i) != string.charAt(compareToChar)) {
                isPalindrome = false;
                break;
            }
            ++i;
        }
        return isPalindrome;
    }
}
