package com.syeedode.corp.amazon.main;

import com.syeedode.corp.amazon.AnagramSolution;
import com.syeedode.corp.amazon.LunchSolution;

/**
 * Amazon Interview
 * <p>
 * Author: syeedode
 * Date: 5/29/17
 */
public class AmazonInterview {
    public static void main(String [] args) {
        System.out.println("Hello World");
        AnagramSolution solution = new AnagramSolution();
        for(Integer i : solution.getAnagramIndicesTwo("bcdaghbabcdaij","bcda")){
            System.out.println(i);
        }
        LunchSolution l = new LunchSolution();
        String[][] lmp = {
                  {"Pizza", "Italian"}
                , {"Curry", "Indian"}
                , {"Masala","Indian"}
        };
        String[][] tcP = {
                {"Jose","Italian"}
            ,   {"John","Indian"}
            ,   {"Sarah","*"}};
        l.matchLunches(lmp,tcP);
    }
}
