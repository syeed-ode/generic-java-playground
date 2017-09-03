package com.syeedode.effectivejava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ad Service Application
 * <p>
 * Author: syeedode
 * Date: 8/30/17
 */
public class GenericReferencing {
    public static void main(String [] args) {
        List<String> ls = new ArrayList<String>();
        List<String> lo = ls;
        ls.add("Hello");
        System.out.println(lo.get(0) + " World");
        lo.add("Really");
        System.out.println(ls.get(1) + " " + lo.get(0) + " World");
        GenericReferencing genericReferencing = new GenericReferencing();
        Rectangle [] rectangles = {new Rectangle()};
        genericReferencing.add(Arrays.asList(rectangles));
    }

    private void add(List<? extends Shape> shapes) {
        for(Shape s : shapes) {
            System.out.println(s);
        }
    }

    public static class Shape {

    }

    public static class Rectangle extends Shape {

    }
}
