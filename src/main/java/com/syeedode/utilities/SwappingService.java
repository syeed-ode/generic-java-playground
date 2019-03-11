package com.syeedode.utilities;

public class SwappingService<T> {

    public void swap(T [] array, int x, int y) {
        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
