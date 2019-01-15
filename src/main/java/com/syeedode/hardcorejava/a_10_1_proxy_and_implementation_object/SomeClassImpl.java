package com.syeedode.hardcorejava.a_10_1_proxy_and_implementation_object;

public class SomeClassImpl {
    private String userName;

    public SomeClassImpl(final String userName) {
        this.userName = userName;
    }

    public void someMethod() {
        System.out.println(this.userName);
    }

    public void someOtherMethod(final String text) {
        System.out.println(text);
    }
}
