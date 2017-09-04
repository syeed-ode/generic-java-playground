package com.syeedode.security.keys;

import sun.security.provider.DSAPrivateKey;
import sun.security.provider.DSAPublicKey;
import sun.security.provider.DSAPublicKeyImpl;

import java.security.*;

/**
 * O'Reilly Java Security Second Edition
 * Generate Sun Provided Asymmetric Key - Chapter 9 - Keys and Certificates
 * <p>
 * Author: syeedode
 * Date: 9/3/17
 */
public class KeyEvaluator {

    public static void assemtricKeyGenorator() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("DSA");
            System.out.println("Got back a syeedsimplementation: " + generator);
            KeyPair keyPair = generator.generateKeyPair();
            System.out.println("Got back an assymetric key par: " + keyPair);
            PrivateKey assymetricPrivateKey = keyPair.getPrivate();
            PublicKey assymetricPublicKey = keyPair.getPublic();
            System.out.println("Public key: " + assymetricPublicKey
                    + "\r\nPrivate key: " + assymetricPrivateKey.toString()
                    + "\n\tFormat: " + assymetricPrivateKey.getFormat()
                    + "\n\tEncoded: " + assymetricPrivateKey.getEncoded()
                    + "\n\tValue (X for private): " + ((DSAPrivateKey) assymetricPrivateKey).getX()
                    + "\n\tAlgorithm: " + assymetricPrivateKey.getAlgorithm()
                    + "\n\tAlgorithm Id: " + ((DSAPrivateKey) assymetricPrivateKey).getAlgorithmId()
            );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void printKeyValue() {
        String keyStr = publicKeyStr();
        try {
            DSAPublicKey dsaKey = new DSAPublicKeyImpl(keyStr.getBytes());
            dsaKey.getY();
            System.out.println("Made it this far: " + keyStr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }

    private static String publicKeyStr() {
        return "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC3dBjRebiL4FM0gBmvBS/lA2K/sOBstWkqnZ76KPadgRyxrbyzuUAo3aY4ZTQ2ZZuUErguY02zAz5HSjyBsiyQ0LC5zuWQ9UcA6jXjsY5dUiCbNWW9vW86ITvXrJIXgjtCJ6vxcNq/AGfv+tpVa4peL9CMSugNa7aEdNug/o3wXl5hyzDNA7biWP+JD7zY2fXjOE0CWjoOUL5hRmIMeqsdm0V7wUU2t+dQnoPLtzCRc/F2FmQol5yyU2Tlcp2+Ihh7ebYcFEl+u+54q5VBZlW55ErgGo104E4IcAviOq1zO/PeGuRs6x/69a2LIcwYjXzAZnmT0KqjL57MnEiPMlb7 syeedode@Syeeds-MacBook-Pro.local";
    }
}
