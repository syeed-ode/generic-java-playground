package com.syeedode.security.common;

import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * O'Reilly Java Security Second Edition
 * SSL Contexts and Key Managers - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/6/17
 */
public class ArgumentValidator {
    public final static String SERVER_OUTPUT_STRING = "Why are you asking me?";

    public static String fromStringArray(String[] args, final int index, String defaultString) {
        return Optional
                .ofNullable(ObjectUtils.isEmpty(args) ? null : args)
                .map(array -> array[index])
                .orElse(defaultString);
    }
}
