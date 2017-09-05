package com.syeedode.exceptions;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class KeyStoreHandlerException extends SyeedsApplicationException {
    public KeyStoreHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyStoreHandlerException(Exception e) {
        super(e);
    }
}
