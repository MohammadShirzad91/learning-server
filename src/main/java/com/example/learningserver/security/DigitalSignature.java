package com.example.learningserver.security;

import java.security.*;
import java.util.Base64;

public class DigitalSignature {
    public static void main(String[] args) throws Exception{
        // 1. Generate a Key Pair (Private and Public Key)
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Key size
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Message to sign
        String message = "This is a confidential message.";

        // 2. Create a Digital Signature
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] digitalSignature = signature.sign();

        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(digitalSignature));

        // 3. Verify the Digital Signature
        Signature signatureVerify = Signature.getInstance("SHA256withRSA");
        signatureVerify.initVerify(publicKey);
        signatureVerify.update(message.getBytes());
        boolean isVerified = signatureVerify.verify(digitalSignature);

        System.out.println("Signature Verified: " + isVerified);
    }

}
