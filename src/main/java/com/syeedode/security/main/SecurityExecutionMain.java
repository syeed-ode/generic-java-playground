package com.syeedode.security.main;

import static com.syeedode.security.keys.AssymetricGenericKeyService.assemtricKeyGenorator;
import static com.syeedode.security.keys.AssymetricGenericKeyService.printKeyValue;
import static com.syeedode.security.keys.syeedsimplementation.generation.SyeedsKeyGeneratorService.keyGeneroatorExecutor;
import static com.syeedode.security.keys.syeedsimplementation.keystore.KeyStoreService.keyStoreEntry;
import static com.syeedode.security.proivders.ProviderListService.printListOfProviders;
import static com.syeedode.security.ssl.SSLServer.runSSLServer;
import static com.syeedode.security.ssl.SSLServerWithContext.executeSSLServerWithContext;

/**
 * O'Reilly Java Security Second Edition
 *
 * <p>
 * Author: syeedode
 * Date: 8/30/17
 */
public class SecurityExecutionMain {
    public static void main(String args []) {
        keyStoreEntry(args);
        runSSLServer();
        executeSSLServerWithContext(args);
        keyGeneroatorExecutor();
        assemtricKeyGenorator();
        printListOfProviders();
        printKeyValue();
    }
}
