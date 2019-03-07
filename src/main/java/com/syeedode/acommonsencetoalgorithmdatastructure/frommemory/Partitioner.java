package com.syeedode.acommonsencetoalgorithmdatastructure.frommemory;

import com.syeedode.utilities.SwappingService;

/**
 * pg 133
 */

public class Partitioner {

    private static final SwappingService<Integer> swapper = new SwappingService<>();

    public static Integer partionFromMemory(Integer [] array, int leftPointer, int rightPointer) {
        int pivotPosition = rightPointer, pivot = array[rightPointer];
        --rightPointer;

        while(true) {
            while (array[leftPointer] < pivot) {
                ++leftPointer;
            }

            while (array[rightPointer] > pivot) {
                --rightPointer;
            }

            if(leftPointer >= rightPointer) {
                break;
            } else {
                swapper.swap(array, leftPointer, rightPointer);
            }
        }

        swapper.swap(array, leftPointer, pivotPosition);

        return leftPointer;
    }
}
