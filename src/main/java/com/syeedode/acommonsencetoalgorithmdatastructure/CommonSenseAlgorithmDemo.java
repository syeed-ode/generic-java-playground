package com.syeedode.acommonsencetoalgorithmdatastructure;

import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.LinkedList;
import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.LinkedList.LinkedListResultSet;
import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.Node;
import com.syeedode.acommonsencetoalgorithmdatastructure.quickselect.QuickselectService.PivotResultSet;

import java.util.Arrays;
import java.util.Objects;

import static com.syeedode.acommonsencetoalgorithmdatastructure.quickselect.QuickselectService.quickselect;

public class CommonSenseAlgorithmDemo {

    public static void main(String [] args) {
        Integer[] initialArray = {0, 5, 2, 1, 6, 3};
        System.out.println("This is where we started: " + Arrays.toString(initialArray));
        // quickSort(initialArray, 0, initialArray.length - 1);

        PivotResultSet pivotResultSet
                = quickselect(initialArray, 1, 0, initialArray.length - 1);
        System.out.println("\n\n" + pivotResultSet);

    }
}
