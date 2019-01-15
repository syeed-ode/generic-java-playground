package com.syeedode.hardcorejava.a_10_7_generate_a_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This invocation handler provides the same functionality
 * as static proxies. However, it uses reflection to do
 * the job.
 *
 * Writing an invocation handler is only the first step in
 * generating a dynamic proxy. See {@code SomeClassFactory}.
 */
public class MethodCountingHandler implements InvocationHandler {

    private final Object impl;
    private int invocationCount = 0;

    public MethodCountingHandler(final Object impl) {
        this.impl = impl;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            /**
             * Inside the invocation handler, this code increments
             * the invocationCount variable and then forwards the
             * call to the implementation using the invoke() method
             * on the Method object.
             */
            this.invocationCount++;
            // System.out.println("Assuring the InvocationHandler is running. My count is: " + invocationCount);
            Object result = method.invoke(impl, args);
            return result;
        } catch (final InvocationTargetException ex) {
            throw ex.getTargetException();
        }
    }

    /**
     * When writing invocation handlers, be careful of methods that
     * return primitive types. The JDK will wrap primitive types in
     * their corresponding wrapper types to return them from a
     * reflexive invocation. The problem is that your handler can
     * return null, but the actual method being called on the
     * implementation cannot. Therefore, if you try to return null
     * after calling a method that returns a primitive, the proxy
     * class will throw a NullPointerException. This
     * NullPointerException applies to the return value, not to the
     * parameters of the method.
     *
     * @return
     */
    public int getInvocationCount() {
        return invocationCount;
    }
}
