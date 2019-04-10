package com.syeedode.acommonsencetoalgorithmdatastructure.quicksort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortServiceTest {
    QuickSortService service = new QuickSortService();

    @Test
    public void quickSort_Success() {
        Integer [] array = {0, 5, 2, 1, 6, 3};
        service.quickSort(array, 0, array.length -1);
        System.out.println(Arrays.asList(array));
    }
}
