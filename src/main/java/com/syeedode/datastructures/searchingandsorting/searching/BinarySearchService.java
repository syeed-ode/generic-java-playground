package com.syeedode.datastructures.searchingandsorting.searching;

/**
 * Cracking the Coding Interview
 * Chapter 10: Sorting and Searching
 * pg: 149; Exercise
 * <p>
 * <p>
 * Author: syeedode
 * Date: 5/29/17
 */
public class BinarySearchService {

    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
