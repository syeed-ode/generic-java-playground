package com.syeedode.security.main;

import com.syeedode.security.proivders.SyeedsProvider;

import java.security.Security;

import static com.syeedode.security.keys.keystore.KeyStoreService.keyStoreEntry;
import static com.syeedode.security.ssl.SSLServer.runSSLServer;

/**
 * O'Reilly Java Security Second Edition
 *
 * <p>
 * Author: syeedode
 * Date: 8/30/17
 */
public class SecurityExecutionMain {
    public static void main(String args []) {
        Security.addProvider(new SyeedsProvider());
//        executeSSLServerWithKeyManager(args);
        keyStoreEntry(args);
        runSSLServer();
//        executeSSLServerWithContext(args);
//        keyGeneroatorExecutor();
//        assemtricKeyGenorator();
//        printListOfProviders();
//        printKeyValue();
    }
}
