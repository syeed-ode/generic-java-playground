package com.syeedode.security.keys.keystore;

import com.syeedode.annotations.ThreadSafe;

import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
@ThreadSafe
public class KeyStoreDto {
    private final String keyAlias;
    private final char[] pwAsCharArray;

    /** * Static factory methods */
    public static KeyStoreDto getInstance(String... args){
        return new KeyStoreDto(args);
    }

    /** * Constructors */
    private KeyStoreDto(String... args){
        String[] validInput = isEmpty(args) ? null : args;
        keyAlias = Optional.ofNullable(validInput)
                .map(a -> a[0])
                .orElse("syeedsgmail");

        pwAsCharArray = Optional.ofNullable(validInput)
                .map(a -> a[1])
                .map(password -> {
                    char c[] = new char[password.length()];
                    password.getChars(0, c.length, c, 0);
                    return c;
                })
                .orElse(null);
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public char[] getPwAsCharArray() {
        return pwAsCharArray;
    }
}
