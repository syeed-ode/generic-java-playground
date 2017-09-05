package com.syeedode.security.keys.syeedsimplementation.keystore;

import com.syeedode.exceptions.ApplicationExceptionService;
import org.springframework.util.StringUtils;

import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Objects;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class KeyStoreService {

    public static void keyStoreEntry(String [] args){
        KeyStoreService keyStoreService = new KeyStoreService();
        KeyStore keyStore = KeyStoreHandler.getKeyStore(null);
        keyStoreService.processAllKeyStoreEntries(keyStoreService, keyStore);
    }

    public void processAllKeyStoreEntries(KeyStoreService keyStoreService, KeyStore keyStore) {
        try {
            for(Enumeration<String> e = keyStore.aliases(); e.hasMoreElements();){
                keyStoreService.keyStorServicer(keyStore, new String[]{e.nextElement(),"changeit"});
            }
        } catch (KeyStoreException exc) {
            handleException(exc);
        }
    }

    public void keyStorServicer(KeyStore keyStore, String [] args) {
        KeyStoreDto keyStoreDto = KeyStoreDto.valueOf(args);
        String keyAlias = keyStoreDto.getKeyAlias();

        try {
            if(keyStore.isKeyEntry(keyAlias)) {
                printKeyInfoFromValidKeyEntry(keyStore, keyStoreDto);
                getCertInfoFromValidKeyEntry(keyStore, keyAlias);
                System.out.println();
            } else if(keyStore.isCertificateEntry(keyAlias)) {
                getCertInfoFromValidCertEntry(keyStore, keyAlias);
                System.out.println();
            } else {
                System.out.println(keyAlias + " is unknown to this keystore");
            }
        } catch (KeyStoreException|UnrecoverableKeyException|NoSuchAlgorithmException e) {
            handleException(e);
        }
        System.out.println("************\r\n\r\n************");
    }

    private void printKeyInfoFromValidKeyEntry(KeyStore keyStore, KeyStoreDto dto)
            throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        String keyAlias = dto.getKeyAlias();
        char[] pwAsCharArray = dto.getPwAsCharArray();

        System.out.println(keyAlias + " is a key entry in the keystore");

        Key key = keyStore.getKey(keyAlias, pwAsCharArray);
        System.out.println("The private key for " + keyAlias
                + " is " + toString(key));

    }

    private void getCertInfoFromValidKeyEntry(KeyStore keyStore, String keyAlias) throws KeyStoreException {
        Certificate certs[] = keyStore.getCertificateChain(keyAlias);
        Certificate possibleIssuingRootCert = certs[0];
        Certificate possibleKeyCert = certs[certs.length - 1];

        printRootAndKeyCertIfValid(keyAlias, possibleIssuingRootCert, possibleKeyCert);
    }

    private void getCertInfoFromValidCertEntry(KeyStore keyStore, String keyAlias) throws KeyStoreException {
        System.out.println(keyAlias + " is a certificate entry in the keystore");
        Certificate cert = keyStore.getCertificate(keyAlias);
        printRootAndKeyCertIfValid(keyAlias, cert, cert);
    }

    private void printRootAndKeyCertIfValid(String keyAlias
            , Certificate possibleIssuingRootCert, Certificate possibleKeyCert) {
        if(possibleIssuingRootCert instanceof X509Certificate) {
            X509Certificate x509Cert = (X509Certificate) possibleIssuingRootCert;
            System.out.println(keyAlias + " is really " + x509Cert.getSubjectDN());
        }
        if(possibleKeyCert instanceof X509Certificate) {
            X509Certificate x509Cert = (X509Certificate) possibleKeyCert;
            System.out.println(keyAlias + " was verified by " + x509Cert.getIssuerDN()
                    + ". But it is still: " + x509Cert.getSubjectDN());
        }
    }

    private String toString(Key key) {
        if(Objects.isNull(key)){
            return "Null key returned";
        }
        String algorithmm = getValueFromField("algorithm: ", key.getAlgorithm());
        String format = getValueFromField("format: ", key.getFormat());
        String endocded = getValueFromField("endocded: ", String.valueOf(key.getEncoded()));
        return algorithmm + format + endocded;
    }

    private String getValueFromField(String fieldName, String value) {
        return StringUtils.isEmpty(value)? "" : "\r\n\t\t" + fieldName + value;
    }

    private void handleException(GeneralSecurityException e) {
        ApplicationExceptionService exHandler = new ApplicationExceptionService();
        exHandler.managerKeyStorServiceException(e);
    }
}
