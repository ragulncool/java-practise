package com.ragul.demo.rsa;

public class Main {
    public static void main(String[] args) throws Exception {

       System.out.println(System.getProperty("user.dir"));

        var privateKey = KeyLoader.loadPrivateKey("private_key.pem");
        var publicKey = PublicKeyLoader.loadPublicKey("public_key.pem");

        String data = "Hello World";

        String signature = Signer.sign(data, privateKey);
        System.out.println("Signature: " + signature);

        boolean isValid = Verifier.verify(data, signature, publicKey);
        System.out.println("Verified: " + isValid);
    }
}