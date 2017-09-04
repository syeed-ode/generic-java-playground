package com.syeedode.security.main;

import static com.syeedode.security.keys.syeedsimplementation.SyeedsKeyService.keyGeneroatorExecutor;
import static com.syeedode.security.proivders.ProviderListService.printListOfProviders;

/**
 * O'Reilly Java Security Second Edition
 *
 * <p>
 * Author: syeedode
 * Date: 8/30/17
 */
public class SecurityExecutionMain {
    public static void main(String args []) {
        keyGeneroatorExecutor();
        //assemtricKeyGenorator();
        printListOfProviders();
        //printKeyValue();
    }
}
