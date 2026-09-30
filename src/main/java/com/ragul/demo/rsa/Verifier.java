package com.ragul.demo.rsa;

import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class Verifier {
//    data: the original message string.
//    signatureBase64: the signature encoded as Base64.
    public static boolean verify(String data, String signatureBase64, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data.getBytes());

        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);
        return signature.verify(signatureBytes);
    }
}