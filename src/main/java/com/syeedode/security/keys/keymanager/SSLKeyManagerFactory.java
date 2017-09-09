package com.syeedode.security.keys.keymanager;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import java.security.*;
import java.util.Optional;


/**
 * O'Reilly Java Security Second Edition
 * SSL Contexts and Key Managers (Working with Key Managers) - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/8/17
 */
public class SSLKeyManagerFactory extends KeyManagerFactorySpi {
    private char [] password;
    private KeyStore keyStore;
    private final String alias;

    public SSLKeyManagerFactory() {
        alias  = System.getProperty("syeed_ode.aliasName","syeedsthirdkey");
        Optional.ofNullable(alias)
                .orElseThrow(() ->
                        new IllegalArgumentException("Must specify an alias property`"));
    }

    @Override
    protected void engineInit(KeyStore ks, char[] chars) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        keyStore = ks;
        password = new char[chars.length];
        System.arraycopy(chars, 0, password, 0, chars.length);
    }

    @Override
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
    }

    @Override
    protected KeyManager[] engineGetKeyManagers() {
        SSLKeyManager [] keyManagers =
                new SSLKeyManager[]{new SSLKeyManager(keyStore, alias, password)};
        return keyManagers;
    }
}
