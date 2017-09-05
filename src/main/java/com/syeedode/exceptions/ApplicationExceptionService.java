package com.syeedode.exceptions;

import com.syeedode.security.keys.syeedsimplementation.keystore.KeyStoreExceptionDto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class ApplicationExceptionService {
    public void managerKeyStorServiceException(Exception e) {
        String message;
        if(e instanceof KeyStoreException) {
            message = "Either finding the keyEntry failed or the key could not be decrypted";
        } else if (e instanceof UnrecoverableKeyException) {
            message = "The key cannot be retrieved from store";
        } else if (e instanceof NoSuchAlgorithmException) {
            message = "No provider with the necessary algorithm found on classpath";
        } else {
            throw new KeyStoreHandlerException(e);
        }
        throw new KeyStoreHandlerException(message, e);
    }

    public void manageKeyStoreHandlerException(Exception e, KeyStoreExceptionDto dto){
        String message;
        if (e instanceof KeyStoreException) {
            message = "Could not identiry correct algorithm: " + dto.getAlgorithm();
        } else if (e instanceof FileNotFoundException) {
            message = "Could not read .keystore file from: " + dto.getFileName();
        } else if (e instanceof IOException) {
            message = "Error in reading the data from the .keystore file: ";
        } else if (e instanceof NoSuchAlgorithmException) {
            message = "No message digest is available on class path to read this .keystore: ";
        } else if (e instanceof CertificateException) {
            message = "Generic format errors in the .keystore data: ";
        } else {
            throw new KeyGeneratorException(e);
        }
        throw new KeyGeneratorException(message, e);
    }
}
