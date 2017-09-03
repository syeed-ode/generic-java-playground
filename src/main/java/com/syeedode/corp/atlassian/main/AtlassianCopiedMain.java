package com.syeedode.corp.atlassian.main;

import java.io.IOException;
import java.util.Scanner;

import static com.syeedode.corp.atlassian.Solution.convert;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: ; Problem 1.1
 * <p>
 * <p>
 * Author: syeedode
 * Date: 5/22/17
 */
public class AtlassianCopiedMain {
    public static void main(String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long _in;
        _in = Long.parseLong(scanner.nextLine());
        scanner.close();
        System.out.println(convert(_in));
    }
}
