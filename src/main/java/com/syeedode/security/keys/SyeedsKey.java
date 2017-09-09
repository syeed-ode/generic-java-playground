package com.syeedode.security.keys;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 9 - Keys and Certificates
 * <p>
 * Author: syeedode
 * Date: 9/3/17
 */
public class SyeedsKey implements Key, PublicKey, PrivateKey {
    private final int initialValue;

    public SyeedsKey(int initialValue) {
        this.initialValue = initialValue;
    }

    @Override
    public String getAlgorithm(){
        return "SYEED_ODE";
    }

    @Override
    public String getFormat(){
        return "Syeed's special format";
    }

    @Override
    public byte[] getEncoded() {
        byte b[] = new byte[4];
        int multiplyBy2TothePowerOf24 = initialValue << 24;
        b[3] = (byte) (multiplyBy2TothePowerOf24 & 0xff);
        b[2] = (byte) ((initialValue << 16) & 0xff);
        b[1] = (byte) ((initialValue << 8) & 0xff);
        b[0] = (byte) ((initialValue << 0) & 0xff);
        return b;
    }
}
