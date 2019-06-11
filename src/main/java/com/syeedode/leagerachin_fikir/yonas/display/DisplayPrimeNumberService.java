package com.syeedode.leagerachin_fikir.yonas.display;

import java.util.List;

/**
 *  Notice that there is a class to do each operation.
 *
 *  Every class should have only one area of responsibility.
 *
 *  Small classes that do one thing is the best way to code.
 */

/**
 * The whole purpose of this class is to display a palindrome
 * list according to the requirements.
 */
public class DisplayPrimeNumberService {

    public void displayPrimeNumber(List<Integer> palPrimeNumberList) {
        int newLineMarker = 0;
        for(int number : palPrimeNumberList) {
            System.out.print(number + "\t");
            ++newLineMarker;
            if(newLineMarker % 10 == 0){
                System.out.println();
            }
        }
    }
}
