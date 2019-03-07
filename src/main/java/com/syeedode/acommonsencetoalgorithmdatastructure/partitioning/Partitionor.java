package com.syeedode.acommonsencetoalgorithmdatastructure.partitioning;

import com.syeedode.utilities.SwappingService;

import java.util.Arrays;

public class Partitionor {

    private static SwappingService<Integer> swapper = new SwappingService<>();

    public static Integer partition(final Integer [] array, int leftPointer, int rightPointer) {
        int pivotPosition = rightPointer
                ,   pivot = array[pivotPosition];
        --rightPointer;

        while (true) {
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
//        System.out.println("\tThis is where the partition completed: " + Arrays.toString(array)
//                + ", and this is the pivot: " + leftPointer);
        return leftPointer;
    }
}
