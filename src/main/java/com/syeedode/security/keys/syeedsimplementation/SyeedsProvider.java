package com.syeedode.security.keys.syeedsimplementation;

import java.security.Provider;

/**
 * O'Reilly Java Security Second Edition
 * Implement a provider class - Chapter 8: Security Providers
 * <p>
 * Author: syeedode
 * Date: 9/3/17
 */
public class SyeedsProvider extends Provider {
    /**
     * Constructs a provider with the specified name, version number,
     * and information.
     *
     */
    public SyeedsProvider() {
        super("SyeedOde", 1.0, "Syeed Ode's Security Provider v1.0");
        put("KeyPairGenerator.SYEED_ODE"
                , "com.syeedode.security.keys.syeedsimplementation.SyeedsKeyPairGenerator");
    }
}
