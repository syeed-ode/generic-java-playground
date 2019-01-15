package com.syeedode.hardcorejava.a_02_11_final_collections_use_umodifiable_set;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This desire to make constant sets and store them in 'final' variables
 * for public use can lead to all sorts of problems.
 */
public class FinalCollections {
    public static class Rainbow {
        /**
         * The goal of this code is to declare a class with a 'Set' of 'final'
         * and 'static' 'Color's representing the colors of the rainbow. You
         * want to be able to use this 'Set' without concerning yourself with
         * the possibility of accidentally changing it. The problem is 'Set'
         * isn't 'final' at all!!
         */
        public final static Set<Color> VALID_COLORS;

        static {
            VALID_COLORS = new HashSet<>();
            VALID_COLORS.add(Color.red);
            VALID_COLORS.add(Color.orange);
            VALID_COLORS.add(Color.yellow);
            VALID_COLORS.add(Color.green);
            VALID_COLORS.add(Color.blue);
            VALID_COLORS.add(Color.decode("#4B0082")); // indigo
            VALID_COLORS.add(Color.decode("#8A2BE2")); // violet
        }

        /**
         * This method breaks the change.
         */
        public static void someMethod() {
            /**
             * The reference to the 'Set' is 'final' but the 'Set' itself is
             * mutable. For collections 'final' is 'not the same' as immutable.
             */
            Set<Color> colors = Rainbow.VALID_COLORS;
            colors.add(Color.black); // <-logic error but allowed by compiler
            System.out.println(colors);
        }

    }

    /**
     * This version of the class is much better. The Set of {@code Color} cannot
     * be modified because it is an immutable object. The {@code Set} is 'final',
     * and the contents of the collection are locked down.
     */
    public static class LockedDownRainbow {
        public final static Set<Color> VALID_COLORS;
        Object d = new Object();

        static {
            Set<Color> temp = new HashSet<>();
            temp.add(Color.red);
            temp.add(Color.orange);
            temp.add(Color.yellow);
            temp.add(Color.green);
            temp.add(Color.blue);
            temp.add(Color.decode("#4B0082")); // indigo
            temp.add(Color.decode("#8A2BE2")); // violet
            VALID_COLORS = Collections.unmodifiableSet(temp);
        }
    }
}
