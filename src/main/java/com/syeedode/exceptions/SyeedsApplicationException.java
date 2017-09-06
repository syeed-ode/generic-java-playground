package com.syeedode.exceptions;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 10: Key Management
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class SyeedsApplicationException extends RuntimeException {
    public SyeedsApplicationException() {
        super();
    }

    public SyeedsApplicationException(String message) {
        super(message);
    }

    public SyeedsApplicationException(Throwable cause) {
        super(cause);
    }

    public SyeedsApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
