package com.syeedode.hardcorejava.a_10_1_proxy_and_implementation_object;

public class SomeClassFactory {

    /**
     * This method sets up the object and binds to the implementation.
     *
     * @return SomeClassProxy
     */
    public static final SomeClassProxy getProxy() {
        SomeClassImpl impl = new SomeClassImpl(System.getProperty("user.name"));
        return new SomeClassProxy(impl);
    }
}
