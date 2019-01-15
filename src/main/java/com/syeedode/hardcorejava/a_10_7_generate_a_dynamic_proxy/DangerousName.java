package com.syeedode.hardcorejava.a_10_7_generate_a_dynamic_proxy;

/**
 * The unqualified name of proxies is considered undefined, although
 * the prefix $Proxy is generally reserved for proxy classes.
 */
public class DangerousName {
    public static final void main(final String[] args) {
        SomeClass proxy = SomeClassFactory.getDynamicSomeClassProxy();
        System.out.println(proxy.getClass().getName());
        try {
            /**
             * Since the unqualified name of a proxy is undefined,
             * using the name literally (as was done here) could
             * cause problems.
             *
             */
            Class cl = Class.forName("$Proxy0"); // <== Dangerous!
            System.out.println(cl.getName());
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
