package com.syeedode.hardcorejava.a_10_1_proxy_and_implementation_object;

public class DemoProxyFactory {

    public static final void main(final String[] args) {
        SomeClassProxy proxy = SomeClassFactory.getProxy();
        proxy.someMethod();
        proxy.someOtherMethod("Our Proxy works!");
    }
}
