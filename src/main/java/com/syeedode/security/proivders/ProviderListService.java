package com.syeedode.security.proivders;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * O'Reilly Java Security Second Edition
 * Security Provider List - Chapter 8: Security Providers
 * <p>
 * Author: syeedode
 * Date: 9/3/17
 */
public class ProviderListService {
    public static void printListOfProviders() {
        try {
            Provider[] providerArray = Security.getProviders();
            System.out.println("List of " + providerArray.length + " providers: \r\n"
                    + newLineEntries(Arrays.toString(providerArray))
                    + "\r\n");
            for(Provider p : providerArray) {
                System.out.println("Provider: " + p);
                System.out.println("\tService information: ");
                System.out.println("\talgorithm, providerName: type.algorithm -> className [\\r\\n alias][\\r\\n attributes]");
                for(Provider.Service service : p.getServices()) {
                    System.out.print("\t\t" + service.getAlgorithm() + ", "+ serviceToStringConverter(service));
                }
                System.out.println("\talgorithm, providerName: type.algorithm -> className [\\r\\n alias][\\r\\n attributes]");
                System.out.println("\tList of keys");
                for(Enumeration e = p.keys(); e.hasMoreElements();){
                    System.out.println("\t\t" + e.nextElement());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String newLineEntries(String inputList) {
        return inputList.replace(",","\r\n");
    }

    private static String serviceToStringConverter(Provider.Service service) {
        String aliasConverted = service.toString().replace("\r\n  aliases: ", "\r\n\t\t\taliases: ");
        String attributeConverted = aliasConverted.replace("\r\n  attributes: ", "\r\n\t\t\tattributes: ");
        return attributeConverted;
    }
}
