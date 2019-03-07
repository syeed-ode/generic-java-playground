package com.syeedode.acommonsencetoalgorithmdatastructure.quicksort;

import static com.syeedode.acommonsencetoalgorithmdatastructure.partitioning.Partitionor.partition;

public class QuickSortService {
    public static void quickSort(Integer [] array, int leftIndex, int rightIndex) {

        if(rightIndex - leftIndex <= 0) {
            return;
        }

        // This partitions the whole array
        int pivotPosition = partition(array, leftIndex, rightIndex);

        // Call quickSort again this time only on everything
        // left of the pivot
        quickSort(array, leftIndex, pivotPosition - 1);

        // Call quickSort again but only on the the right side
        // of the pivot
        quickSort(array, pivotPosition + 1, rightIndex);
    }
}
