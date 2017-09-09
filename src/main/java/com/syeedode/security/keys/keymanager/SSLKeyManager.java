package com.syeedode.security.keys.keymanager;

import com.syeedode.annotations.ThreadSafe;
import com.syeedode.exceptions.SSLKeyManagerException;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.X509KeyManager;
import java.net.Socket;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.syeedode.security.common.ArgumentValidator.EMPTY_ARRAY;
import static java.util.stream.Collectors.toList;

/**
 * O'Reilly Java Security Second Edition
 * SSL Contexts and Key Managers (Working with Key Managers) - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/6/17
 */
@ThreadSafe
public class SSLKeyManager implements X509KeyManager {
    private final String alias;
    private final KeyStore keyStore;
    private final char [] passsword;
    private final String type;
    private final String issuer;


    /** Contstructor */
    SSLKeyManager(KeyStore ks, String aliasOfKeyBeingMangaged, char [] pw) {
        keyStore = ks;
        alias = aliasOfKeyBeingMangaged;
        passsword = pw;
        try {
            java.security.cert.Certificate cert = keyStore.getCertificate(alias);
            this.type = cert.getPublicKey().getAlgorithm();
            X509Certificate x509Cert = (X509Certificate) cert;
            issuer = x509Cert.getIssuerDN().getName();
        } catch (KeyStoreException e) {
            throw new SSLKeyManagerException(aliasOfKeyBeingMangaged + " has a bad key");
        }
    }

    @Override
    public String[] getClientAliases(String s, Principal[] principals) {
        String result = chooseClientAlias(new String[]{s}, principals, null);
        return Objects.isNull(result) ? (String [])EMPTY_ARRAY : new String[]{result};
    }

    @Override
    public String chooseClientAlias(String[] strings, Principal[] principals, Socket socket) {
        if(!Arrays.asList(strings).contains(type)){
            System.out.println("Couldn't find the correct algorithm for the alias");
            return null;
        }
        return Arrays.stream(principals)
                    .filter(Objects::nonNull)
                    .filter(p -> p.equals(issuer))
                    .findFirst()
                    .map(principal1 -> {
                        return alias;
                    })
                    .orElse(null);
    }

    @Override
    public String[] getServerAliases(String s, Principal[] principals) {
        return getClientAliases(s,principals);
    }

    @Override
    public String chooseServerAlias(String s, Principal[] principals, Socket socket) {
        return chooseClientAlias(new String[]{s}, principals, null);
    }

    @Override
    public X509Certificate[] getCertificateChain(String s) {
        java.security.cert.Certificate [] certs;
        try {
            certs = keyStore.getCertificateChain(s);
        } catch (KeyStoreException e) {
            e.printStackTrace();
            throw new SSLKeyManagerException("Couldn't get the certificate chain");
        }

        List<java.security.cert.Certificate> validCertList = Arrays.asList(certs)
                .stream()
                .filter(c -> c instanceof X509Certificate)
                .collect(toList());

        return CollectionUtils.isEmpty(validCertList)
                ? (X509Certificate[]) EMPTY_ARRAY
                : (X509Certificate[]) validCertList.toArray();
    }

    @Override
    public PrivateKey getPrivateKey(String s) {
        try {
            return (PrivateKey) keyStore.getKey(alias, passsword);
        } catch (Exception e) {
            throw new SSLKeyManagerException("Couldn't get private key", e);
        }
    }
}
