package com.syeedode.datastructures.bigO.recursive;

import org.springframework.stereotype.Service;

/**
 * Cracking the Coding Interview
 * Chapter 5: Big O
 * pg: 44, bottom
 */

@Service
public class RecursionService {

    public int recursiveFunction(int n) {
        if(n < 1) {
            return 1;
        }
        return recursiveFunction(n -1) + recursiveFunction(n - 1);
    }
}
