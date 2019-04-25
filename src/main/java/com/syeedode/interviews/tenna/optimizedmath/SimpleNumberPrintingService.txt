package com.syeedode.interviews.tenna.optimizedmath;

/**
 * CONSIDERATIONS:
 *      1) Program should be short (this is taken to mean no long map with all numbers)
 *      2) The requirement states only two, three, odd, and even should be printed
 */
public class SimpleNumberPrintingService {

    public static void main(String [] args) {
        System.out.println("The number '1' is odd.");
        System.out.println("The number '2' is even.");
        System.out.println("The number '3' is divisible by three.");
        for(int i = 4; i < 101; i++) {
            boolean even = false;
            if(i % 2 == 0) {
                even = true;
            }
            if(i % 3 == 0) {
                System.out.println("The number '" + i + "' is divisible by "
                        + (even ? "two and " : "")
                        + "three.");
            } else {
                System.out.println("The number '" + i + "' is "
                        + (even ? "even." : "odd."));
            }
        }
    }
}
