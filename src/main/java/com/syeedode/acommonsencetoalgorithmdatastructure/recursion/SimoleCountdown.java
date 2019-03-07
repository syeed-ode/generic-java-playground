package com.syeedode.acommonsencetoalgorithmdatastructure.recursion;

public class SimoleCountdown {
    public static void displayCountdown(int x) {
        if(x > 0) {
            System.out.println(x);
            displayCountdown(--x);
        }
    }
}
