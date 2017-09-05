package com.syeedode.exceptions;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class KeyGeneratorException extends SyeedsApplicationException {
    public KeyGeneratorException(Exception e) {
        super(e);
    }

    public KeyGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }
}
