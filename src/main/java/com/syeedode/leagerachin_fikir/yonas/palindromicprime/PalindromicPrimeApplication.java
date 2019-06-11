package com.syeedode.leagerachin_fikir.yonas.palindromicprime;

import com.syeedode.leagerachin_fikir.yonas.display.DisplayPrimeNumberService;
import com.syeedode.leagerachin_fikir.yonas.palindromicprime.service.PalindromeService;
import com.syeedode.leagerachin_fikir.yonas.palindromicprime.service.PrimeNumberService;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPrimeApplication {

    public static void main(String [] args) {
        PrimeNumberService primeNumberService = new PrimeNumberService();
        PalindromeService palindromeService = new PalindromeService();
        DisplayPrimeNumberService displayPrimeNumberService = new DisplayPrimeNumberService();
        List<Integer> palindromicPrimeList = new ArrayList<>();
        for(int i = 0; palindromicPrimeList.size() < 100; i++) {
            // There are less palindromes than prime numbers so check for
            // palindrome first. It will save time
            if(palindromeService.isNumberAPalindrome(i) && primeNumberService.isPrimeNumber(i)) {
                // a List is just like an array. The <> tells the compiler what
                // type of list. With List<Integer>  we have a list of Integers.
                // We use a list because the size is dynamic. In arrays, the size
                // is fixed.
                palindromicPrimeList.add(i);
                System.out.println("Added " + i + " to the list. There are now "
                        + palindromicPrimeList.size() + " items in the list.");
            }
        }

        displayPrimeNumberService.displayPrimeNumber(palindromicPrimeList);
    }
}
