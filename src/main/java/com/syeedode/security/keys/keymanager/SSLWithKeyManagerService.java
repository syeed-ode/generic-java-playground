package com.syeedode.security.keys.keymanager;

import com.syeedode.exceptions.SSLKeyManagerException;
import com.syeedode.security.ssl.SSLServer;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.security.KeyStore;

import static com.syeedode.security.common.ArgumentValidator.fromStringArray;

/**
 * O'Reilly Java Security Second Edition
 * SSL Contexts and Key Managers (Working with Key Managers) - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/8/17
 */
public class SSLWithKeyManagerService {
    public static void executeSSLServerWithKeyManager(String [] args) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyStore keyStore = KeyStore.getInstance("jceks");
            char [] password = fromStringArray(args,1, "changeit").toCharArray();
            String keystoreLocation = fromStringArray(args,0, "/Users/syeedode/.keystore");
            keyStore.load(new FileInputStream(keystoreLocation), null);

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SYEED_ODE");
            keyManagerFactory.init(keyStore, password);
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            ServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
            ServerSocket serverSocket = serverSocketFactory.createServerSocket(9096);

            while (true) {
                SSLServer.getInstance(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            throw new SSLKeyManagerException("SSLWithKeyManagerService.executeSSLServerWithKeyManager failed", e);
        }
    }
}
