package com.syeedode.hardcorejava.a_10_7_generate_a_dynamic_proxy;

public class DemoDynamicProxy {
    public static final void main(String [] args) {
        SomeClass proxy = SomeClassFactory.getDynamicSomeClassProxy();
        proxy.someMethod();
        proxy.someOtherMethod("Our proxy works");
    }
}
