package com.syeedode.reflection.a_2_1_class_that_doesnt_use_constraints;

public class FinalConstants {
    /**
     * Primitive finals are substituted at compile time with their values.
     * If you change a 'final' that is used by other classes, you must
     * remember to recompile those other classes or your change will not
     * take effect.
     */
     public static class CircleTools {
        /** Primitive constants are changed at compile time */
        public final static double PI = 3.141;

        public double getCircleArea(final double radius) {
            return (Math.pow(radius, 2) * PI);
        }

        public double getCircleCircumference(final double radius) {
            return ((radius * 2) * PI);
        }

        public double getCirclExtrudedVolume(final double radius, final double height) {
            return ((radius * 2 * height) * PI);
        }
    }
}
