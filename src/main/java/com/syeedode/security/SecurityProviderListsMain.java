package com.syeedode.security;

import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

/**
 * Ad Service Application
 * <p>
 * Author: syeedode
 * Date: 8/30/17
 */
public class SecurityProviderListsMain {
    public static void main(String args []) {
        try {
            Provider[] providerArray = Security.getProviders();
            for(Provider p : providerArray) {
                System.out.println(p);
                for(Enumeration e = p.keys(); e.hasMoreElements();){
                    System.out.println("\t" + e.nextElement());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
