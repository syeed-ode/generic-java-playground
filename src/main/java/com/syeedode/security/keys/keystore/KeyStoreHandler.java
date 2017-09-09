package com.syeedode.security.keys.keystore;

import com.syeedode.annotations.ThreadSafe;
import com.syeedode.exceptions.ApplicationExceptionService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;
import java.util.Optional;

/**
 * O'Reilly Java Security Second Edition
 * The KeyStore Class - Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
@ThreadSafe
public class KeyStoreHandler {
    private final KeyStore keyStore;
    private final char[] password;
    private static final String USER_HOME = "user.home";
    private static final String HOME_DIRECTORY  = System.getProperty(USER_HOME);
    private static final String KEYSTORE_HOME = HOME_DIRECTORY + File.separator + ".keystore";

    /** * Static factory metnods */
    public static KeyStore getKeyStore(char [] password) {
        return new KeyStoreHandler(password).getKeyStore();
    }

    public static KeyStoreHandler getKeyStoreHandler(char [] password) {
        return new KeyStoreHandler(password);
    }

    /** * Constructors */

    /**
     * Remember the password can be null. It indicates
     * the keystore can be read but is unverified.
     */
    private KeyStoreHandler(char [] password) {
        if(Objects.nonNull(password)) {
            int userInputPasswordLength = password.length;
            this.password = new char[userInputPasswordLength];
            System.arraycopy(password, 0, this.password, 0, userInputPasswordLength);
        } else {
            this.password = null;
        }

        KeyStoreExceptionDto exceptionDto = new KeyStoreExceptionDto(KEYSTORE_HOME);

        KeyStore tempKeystore = null;
        try {
            exceptionDto.setAlgorithm(KeyStore.getDefaultType());
            /** * Meat and Potatoes */
            tempKeystore = KeyStore.getInstance(exceptionDto.getAlgorithm());
            FileInputStream fileInputStream = new FileInputStream(exceptionDto.getFileName());
            tempKeystore.load(fileInputStream, this.password);
        } catch (NoSuchAlgorithmException|CertificateException|IOException|KeyStoreException e) {
            handleException(e, exceptionDto);
        }
        keyStore = tempKeystore;
    }

    public KeyStore getKeyStore() {
        return keyStore;
    }

    public void store() throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException {
        /**
         * Reading requires no passowrd. But storing (writing) does
         */
        Optional.ofNullable(password)
                .orElseThrow(() -> new IllegalArgumentException("Can't store w/o password"));

        FileOutputStream fileOutputStream = new FileOutputStream(KEYSTORE_HOME);
        keyStore.store(fileOutputStream, password);
        fileOutputStream.close();
    }

    private void handleException(Exception e, KeyStoreExceptionDto exceptionDto) {
        e.printStackTrace();

        ApplicationExceptionService exHandler = new ApplicationExceptionService();
        exHandler.manageKeyStoreHandlerException(e, exceptionDto);
    }
}
