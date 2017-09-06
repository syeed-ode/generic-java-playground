package com.syeedode.exceptions;

/**
 * O'Reilly Java Security Second Edition
 * JSSE Certificates - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class X500NameException extends SyeedsApplicationException {
    public X500NameException() {
        super("Name provided to the constructor was null");
    }
}
