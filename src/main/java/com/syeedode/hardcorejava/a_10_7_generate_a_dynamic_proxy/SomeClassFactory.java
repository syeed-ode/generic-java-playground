package com.syeedode.hardcorejava.a_10_7_generate_a_dynamic_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * This is the second step in generating a dynamic proxy. This
 * step generates a dynamic proxy for the users. Once you have
 * an invocation handler, you must generate a proxy for the
 * users.
 *
 * Furthermore, according to the proxy design pattern, you
 * have to make sure that the proxy looks like the implementation.
 *
 * You can do this by using a java.lang.reflect.Proxy class in
 * conjunction with your proxy factory, {@code SomeClassFactory}.
 *
 * In this version of the factory method, {@code SomeClass} is an
 * interface implemented by the actual implementation, named
 * {@code SomeClassImpl}.
 *
 */
public class SomeClassFactory {

    /**
     * This allows you to tell the {@code Proxy} class to generate
     * a new proxy that implements the interface {@code SomeClass}
     * and uses the invocation handler.
     *
     * @return SomeClass {interface}
     */
    public static final SomeClass getDynamicSomeClassProxy() {
        SomeClassImpl impl = new SomeClassImpl(
                System.getProperty("user.name"));

        /**
         * Used to invoke {@code SomeClassImpl}
         */
        InvocationHandler handler = new MethodCountingHandler(impl);

        /**
         * {@code SomeClassImpl} implements this interface
         */
        Class[] interfaces = new Class [] {SomeClass.class};

        ClassLoader loader = SomeClassFactory.class.getClassLoader();

        /**
         * {@code SomeClass} is an interface implemented by
         * {@code SomeClassImpl}
         */
        SomeClass proxy =
                            /**
                             * {@code Proxy} class generates a new
                             * proxy that implements the interface
                             * {@code SomeClass} and uses the
                             * invocation handler {@code
                             * java.lang.reflect.InvocationHandler}.
                             *
                             * The {@code Proxy} class plays a pivotal
                             * role in creating and managing new proxy
                             * classes in the virtual machine.
                             *
                             * This method is a shortcut to calling
                             * getProxyClass() and then calling
                             * newInstance() on the resulting class.
                             */
                (SomeClass) Proxy.newProxyInstance(
                          /** */
                          loader

                           /** {@code SomeClassImpl} implements this
                           *  interface */
                        , interfaces

                          /** Used to invoke {@code SomeClassImpl} */
                        , handler);
        return proxy;
    }
    /**
     * {@code Proxy.getProxyClass()}
     *
     * This is the prime method in the creation of the actual proxy
     * class. It takes an
     *      array of interfaces and
     *      a class loader as arguments
     * and generates the byte code for the proxy class at runtime.
     *
     * Once the class is generated, it can be instantiated and used.
     *
     * It is then cached and returned the next time the method is
     * called with the same parameters. Since the generation of the
     * proxy class is relatively slow, this improves the performance
     * of proxies significantly.
     */
}
