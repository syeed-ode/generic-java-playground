package com.syeedode.acommonsencetoalgorithmdatastructure.recursion;

public class FactorialCalculator {
    public static int returnFactorial(int x) {
        if(x > 0) {
            System.out.println("The current value of x: " + x);
            return x * returnFactorial(--x);
        }
        return 1;
    }
}
