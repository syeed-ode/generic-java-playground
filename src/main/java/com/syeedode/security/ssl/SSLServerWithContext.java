package com.syeedode.security.ssl;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.security.*;
import java.security.cert.CertificateException;

import static com.syeedode.security.common.ArgumentValidator.fromStringArray;

/**
 * O'Reilly Java Security Second Edition
 * SSL Contexts and Key Managers - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/6/17
 */
public class SSLServerWithContext {

    /**
     * @throws NoSuchAlgorithmException - keyManagerFactory.init
     * @throws NoSuchAlgorithmException - SSLContext.getInstance
     * @throws NoSuchAlgorithmException - KeyManagerFactory.getInstance With the
     *                                    security provider that comes with Sun's
     *                                    implementation of JSSE, the algorithm
     *                                    must be "SunX509". If not found on
     *                                    classpath the exception is thrown.
     * @throws NoSuchAlgorithmException - keyStore.load
     * @throws CertificateException - keyStore.load
     * @throws KeyManagementException - sslContext.init
     * @throws UnrecoverableKeyException - keyManagerFactory.init
     * @throws KeyStoreException - keyManagerFactory.init
     * @throws KeyStoreException - KeyStore.getInstance when there is no provider
     *                              to support the algorithm type.  When keystore
     *                              object is created, it is initially empty
     */
    public static void executeSSLServerWithContext(String [] args){
        String keystoreLocation = fromStringArray(args,0, "/Users/syeedode/.keystore");
        char [] password = fromStringArray(args,1, "changeit").toCharArray();
        SSLContext sslContext = null;
        KeyManagerFactory keyManagerFactory = null;
        KeyStore keyStore = null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            keyManagerFactory = KeyManagerFactory.getInstance("SUNX509");
            keyStore = KeyStore.getInstance("jceks");
            keyStore.load(new FileInputStream(keystoreLocation), null);
            keyManagerFactory.init(keyStore,password);
            sslContext.init(keyManagerFactory.getKeyManagers(),null,null);

            ServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
            ServerSocket serverSocket = serverSocketFactory.createServerSocket(9096);
            while (true) {
                SSLServer.getInstance(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}