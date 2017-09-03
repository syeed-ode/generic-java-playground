package com.syeedode.datastructures.searchingandsorting.sorting;

/**
 * Cracking the Coding Interview
 * Chapter 10: Sorting and Searching
 * pg: 146; Exercise
 * <p>
 * <p>
 * Author: syeedode
 * Date: 5/29/17
 */
public class QuickSortingService {

    public void quickSort(int [] inputArray, int left, int right) {
        int index = partition(inputArray, left, right);
        if (left < index - 1) { // Sort left half
            quickSort(inputArray, left, index - 1);
        }
        if (index < right) { // Sort right half
            quickSort(inputArray, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be an element

        while (left <= right) { // Until we've gone through the whole array
            // Find element on left that should be on right
            while (arr[left] < pivot) {
                left++;
            }

            // Find element on right that should be on left
            while (arr[right] > pivot) {
                right--;
            }

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
