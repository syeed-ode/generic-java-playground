package com.syeedode.security.keys.syeedsimplementation.generation;

import com.syeedode.security.proivders.SyeedsProvider;

import java.security.*;
import java.util.Arrays;

/**
 * O'Reilly Java Security Second Edition
 * Chapter 9 - Keys and Certificates
 * <p>
 * Author: syeedode
 * Date: 9/3/17
 */
public class SyeedsKeyGeneratorService {
    public static void keyGeneroatorExecutor() {
        Security.addProvider(new SyeedsProvider());
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("SYEED_ODE");
            kpg.initialize(0, new SecureRandom());
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey privateKey = kp.getPrivate();
            PublicKey publicKey = kp.getPublic();
            System.out.println("Recieved a key pair: " + kp
                    + "\r\nPrivate key: " + privateKey
                    + "\r\n\tEncoded: " + Arrays.toString(privateKey.getEncoded())
                    + "\r\nPublic key : " + publicKey
                    + "\r\n\tEncoded: " + Arrays.toString(publicKey.getEncoded())
            );
            System.out.println("\n");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
