package com.syeedode.datastructures.searchingandsorting.sorting;

/**
 * Cracking the Coding Interview
 * Chapter 10: Sorting and Searching
 * pg: 146; Exercise
 * <p>
 * <p>
 * Author: syeedode
 * Date: 5/27/17
 */

/**
 *  RUNTIME: O(n log(n))
 *  MEMORY:  O(n)
 */
public class MergeSortingService {

    public void mergeSort(int [] arrayToSort) {
        int [] helper = new int[arrayToSort.length];
        mergeSort(arrayToSort, helper, 0, arrayToSort.length -1);
    }

    private void mergeSort(int[] array, int[] helper, int low, int high) {
        if(low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle+1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private void merge(int[] array, int[] helper, int low, int middle, int high) {
        /* copy both halves into a helper array */
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft  = low;
        int helperRight = middle + 1;
        int current = low;

        /* Iterate through helper array. Compare the left and right half, copying back
         * the smaller element from the two halves into the original array
         */
        while (helperLeft <= middle && helperRight <= high) {
            if(helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* Copy the rest of the left side of the array into the target array
         */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

}
