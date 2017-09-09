package com.syeedode.exceptions;

/**
 * O'Reilly Java Security Second Edition
 * SSL Contexts and Key Managers (Working with Key Managers) - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/6/17
 */
public class SSLKeyManagerException extends SyeedsApplicationException {
    public SSLKeyManagerException(String message){
        super(message);
    }

    public SSLKeyManagerException(String message, Throwable cause){
        super(message, cause);
    }
}
