package com.syeedode.hardcorejava.a_10_7_generate_a_dynamic_proxy;

public class SomeClassImpl implements SomeClass {
    private final String name;

    public SomeClassImpl(String property) {
        name = property;
    }

    @Override
    public void someMethod() {
        System.out.println("This is the name: " + this.name);
    }

    @Override
    public void someOtherMethod(String text) {
        System.out.println(text);
    }
}
