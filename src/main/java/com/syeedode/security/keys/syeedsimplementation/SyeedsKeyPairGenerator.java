package com.syeedode.security.keys.syeedsimplementation;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 9 - Keys and Certificates
 * <p>
 * Author: syeedode
 * Date: 9/3/17
 */
public class SyeedsKeyPairGenerator extends KeyPairGenerator {


    SecureRandom random = new SecureRandom();

    /**
     * Creates a KeyPairGenerator object for the specified algorithm.
     *
     */
    public SyeedsKeyPairGenerator() {
        super("SYEED_ODE");
    }

    public void initialize(int strength, SecureRandom secureRandom) {
        random = secureRandom;
    }

    public KeyPair generateKeyPair() {
        int rotValue =  random.nextInt() % 25;
        SyeedsKey publicKey =  new SyeedsKey(rotValue);
        SyeedsKey privateKey =  new SyeedsKey(-rotValue);
        return new KeyPair(publicKey, privateKey);
    }
}
