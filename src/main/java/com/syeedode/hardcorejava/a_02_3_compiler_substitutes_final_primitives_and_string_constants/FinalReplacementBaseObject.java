package com.syeedode.hardcorejava.a_02_3_compiler_substitutes_final_primitives_and_string_constants;

import java.awt.*;

public class FinalReplacementBaseObject {
    /**
     * Also, primitive and String method-scoped 'final' variables are not
     * substituted at compile time like prmitive and String method-scoped
     * constants.
     */
    public final static String A_STRING = "Hardcore Java";

    public final static int AN_INT = 5;

    public final static double A_DOUBLE = 102.55d;

    public final static int[] AN_ARRAY = new int[] {1, 2,3,6, 9, 18, 36};

    public final static Color A_COLOR = new Color(45, 0, 155);

    public void someMethod() {
        System.out.println(A_STRING);
        System.out.println(AN_INT);
        System.out.println(A_DOUBLE);
        System.out.println(AN_ARRAY);
        System.out.println(A_COLOR);
    }

    /**
     * Once the compiler sees code such as this, it starts substituting
     * out the primitives and 'String' objects. After the first pass of
     * the compiler, the class will look something like this.
     */
    public void compileTimeSubstitutionOfSomeMethod() {
        /**
         *  The primitive and 'String' constants were substituted while
         *  other constructed types were left as variables.
         *
         */
        System.out.println("Hardcore Java");
        System.out.println(5);
        System.out.println(102.55D);
        System.out.println(AN_ARRAY);
        System.out.println(A_COLOR);
    }

    /**
     * The compiler will concatenate consecutive 'String' literals to form
     * one literal. The following two lines are identical from the point
     * of view of the compiler.
     */
    public final static String A_STRING1 = "Hardcore Java";
    public final static String A_STRING2 = "Hardcore " +  "Java";
}
