package com.syeedode.datastructures.searchingandsorting.main;

import com.syeedode.datastructures.searchingandsorting.searching.BinarySearchService;

/**
 * Cracking the Coding Interview
 * Chapter 10: Sorting and Searching
 * pg: 146; Exercise
 * <p>
 * <p>
 * Author: syeedode
 * Date: 5/26/17
 */
public class SearchingAndSorting {

    public static void main(String [] args) {
        System.out.println("Hello World!!");
//        MergeSortingService service = new MergeSortingService();
//        service.mergeSort(arrayToSort);
//        int [] arrayToSort = {3, 1, 4, 9, 2};
        int [] arrayToSort = {4, 3, 1, 9, 2};
//        QuickSortingService quickSortingService = new QuickSortingService();
//        quickSortingService.quickSort(arrayToSort,0, arrayToSort.length -1);
        BinarySearchService binarySearchService = new BinarySearchService();
        int[] array = {3, 6, 9, 12, 15, 18};
        int loc = binarySearchService.binarySearch(array, 5);
        System.out.println("Found x at: " + loc);
    }
}
