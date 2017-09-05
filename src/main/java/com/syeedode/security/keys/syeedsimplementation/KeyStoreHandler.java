package com.syeedode.security.keys.syeedsimplementation;

import java.io.*;
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
public class KeyStoreHandler {
    private final KeyStore keyStore;
    private final char[] password;
    private static final String USER_HOME = "user.home";
    private static final String HOME_DIRECTORY  = System.getProperty(USER_HOME);
    private static final String KEYSTORE_HOME = HOME_DIRECTORY + File.separator + ".keystore";

    /**
     * Remember the password can be null. It indicates
     * the keystore can be read but is unverified.
     */
    public KeyStoreHandler(char [] password) {
        KeyStore tempKeystore = null;
        boolean exceptionCaught = false;
        if(Objects.nonNull(password)) {
            int userInputPasswordLength = password.length;
            this.password = new char[userInputPasswordLength];
            System.arraycopy(password, 0, this.password, 0, userInputPasswordLength);
        } else {
            this.password = null;
        }

        String fname = KEYSTORE_HOME;
        FileInputStream fileInputStream = null;
        String algorithmType = null;
        try {
            algorithmType = KeyStore.getDefaultType();
            tempKeystore = KeyStore.getInstance(algorithmType);
            fileInputStream = new FileInputStream(fname);
            tempKeystore.load(fileInputStream, this.password);
        } catch (KeyStoreException e) {
            e.printStackTrace();
            exceptionCaught = true;
            System.out.println("Could not identiry correct algorithm: " + algorithmType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            exceptionCaught = true;
            System.out.println("Could not read .keystore file from: " + fname);
        } catch (IOException e) {
            exceptionCaught = true;
            e.printStackTrace();
            System.out.println("Error in reading the data from the .keystore file" + e);
        } catch (NoSuchAlgorithmException e) {
            exceptionCaught = true;
            e.printStackTrace();
            System.out.println("No message digest is available on class path to read this .keystore" + e);
        } catch (CertificateException e) {
            exceptionCaught = true;
            e.printStackTrace();
            System.out.println("Generic format errors in the .keystore data" + e);
        }
        keyStore = tempKeystore;
        if(exceptionCaught) {
            System.exit(0);
        }
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
}
