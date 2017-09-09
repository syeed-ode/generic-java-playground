package com.syeedode.security.keys.keystore;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class KeyStoreExceptionDto {
    private final String fileName;
    private String algorithm;

    public KeyStoreExceptionDto(String filename) {
        fileName = filename;
    }

    public String getFileName() {
        return fileName;
    }

    public String getAlgorithm() {
        return String.valueOf(algorithm);
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

}