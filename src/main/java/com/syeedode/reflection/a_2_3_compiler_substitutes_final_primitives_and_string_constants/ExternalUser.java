package com.syeedode.reflection.a_2_3_compiler_substitutes_final_primitives_and_string_constants;

/**
 * This is a class that uses the constant 'A_STRING' from
 * FinalReplacementBaseObject. It has a problem. It will have to
 * be recompiled to trigger a resubstitution using any new
 * 'A_STRING' value. But the Java compiler will not notice this
 * dependency.
 */
public class ExternalUser {
    public static void main(String [] args) {
        System.out.println("The title of the book is: "
                + FinalReplacementBaseObject.A_STRING);
    }

}
