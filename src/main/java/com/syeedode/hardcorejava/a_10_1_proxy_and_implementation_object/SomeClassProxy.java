package com.syeedode.hardcorejava.a_10_1_proxy_and_implementation_object;

/**
 * We created this proxy because we want a user to be able to
 * use the {@code SomeClass} class without having direct
 * access to it. Therefore we needed a proxy. We have a series
 * of methods that are identical to the implementation.
 */
public class SomeClassProxy {
    private final SomeClassImpl impl;

    public SomeClassProxy(final SomeClassImpl impl) {
        this.impl = impl;
    }

    public void someMethod() {
        this.impl.someMethod();
    }

    public void someOtherMethod(final String text) {
        this.impl.someOtherMethod(text);
    }
}
