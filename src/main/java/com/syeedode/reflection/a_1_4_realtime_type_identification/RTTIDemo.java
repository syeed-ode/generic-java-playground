package com.syeedode.reflection.a_1_4_realtime_type_identification;

public class RTTIDemo {
    public final static void basicRTTIDemo() {
        Float y = new Float(15.0);
        String name = "Fred";
        System.out.println(y.getClass());
        System.out.println(name.getClass());
    }

    public static void main(String [] arbgs) {
        basicRTTIDemo();
    }

    public static class A {

    }

    public static class B extends A {

    }

    public static class C {

    }

    /**
     * Example 1-5
     */
    /** An object can only be cast to its type
     *  or to a type that it is inherited from.
     */
    public final static void castingWithRTTI() {
        A a = null;
        A a1 = new A();
        B b = new B();
        C c = new C();

        a = (A) b; // no problem
        b = (B) a; // still no problem, casting back to waht it was created as
        a = a1; // Same type no problem
        Object d = (Object) c; // no problem because of implicit inheritance
        c = (C) d; // casting back
        /** b = (A) a1; // compileTime error B is A, A is not B
            b = (B) c;  // compile Time error C has nothing to do with B
         */
    }
}
