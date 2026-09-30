// java
package com.ragul.demo.rsa;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Base64;

public class KeyLoader {

    public static PrivateKey loadPrivateKey(String path) throws Exception {
        byte[] pemBytes = readPemBytes(path);
        String pem = new String(pemBytes).trim();

        if (pem.contains("-----BEGIN RSA PRIVATE KEY-----")) {
            byte[] pkcs1 = extractBase64(pem, "-----BEGIN RSA PRIVATE KEY-----", "-----END RSA PRIVATE KEY-----");
            return generatePrivateFromPKCS1(pkcs1);
        } else if (pem.contains("-----BEGIN PRIVATE KEY-----")) {
            byte[] pkcs8 = extractBase64(pem, "-----BEGIN PRIVATE KEY-----", "-----END PRIVATE KEY-----");
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(pkcs8);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(spec);
        } else {
            throw new IllegalArgumentException("Unsupported PEM format: no recognized PRIVATE KEY header");
        }
    }

    private static byte[] readPemBytes(String path) throws IOException {
        Path p = Paths.get(path);
        if (Files.exists(p)) {
            return Files.readAllBytes(p);
        }
        InputStream in = KeyLoader.class.getResourceAsStream("/" + path);
        if (in == null) {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        }
        if (in == null) {
            throw new IOException("PEM file not found at filesystem path or classpath: " + path);
        }
        return in.readAllBytes();
    }

    private static byte[] extractBase64(String pem, String beginMarker, String endMarker) {
        int start = pem.indexOf(beginMarker);
        int end = pem.indexOf(endMarker);
        if (start < 0 || end < 0) throw new IllegalArgumentException("PEM markers not found");
        String b64 = pem.substring(start + beginMarker.length(), end).replaceAll("\\s+", "");
        return Base64.getDecoder().decode(b64);
    }

    private static PrivateKey generatePrivateFromPKCS1(byte[] pkcs1) throws Exception {
        // parse PKCS#1 ASN.1 sequence to get RSA components
        try (ByteArrayInputStream in = new ByteArrayInputStream(pkcs1)) {
            int seq = in.read();
            if (seq != 0x30) throw new IOException("Invalid PKCS#1 format (expected sequence)");
            readLength(in); // skip sequence length
            // version
            readInteger(in);
            BigInteger n = readInteger(in);
            BigInteger e = readInteger(in);
            BigInteger d = readInteger(in);
            BigInteger p = readInteger(in);
            BigInteger q = readInteger(in);
            BigInteger dp = readInteger(in);
            BigInteger dq = readInteger(in);
            BigInteger qi = readInteger(in);

            RSAPrivateCrtKeySpec spec = new RSAPrivateCrtKeySpec(n, e, d, p, q, dp, dq, qi);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(spec);
        }
    }

    private static BigInteger readInteger(InputStream in) throws IOException {
        int tag = in.read();
        if (tag != 0x02) throw new IOException("Expected INTEGER tag but found: " + tag);
        int len = readLength(in);
        byte[] bytes = in.readNBytes(len);
        return new BigInteger(1, bytes);
    }

    private static int readLength(InputStream in) throws IOException {
        int b = in.read();
        if (b < 0) throw new IOException("Invalid length byte");
        if ((b & 0x80) == 0) {
            return b;
        }
        int num = b & 0x7F;
        int len = 0;
        for (int i = 0; i < num; i++) {
            int next = in.read();
            if (next < 0) throw new IOException("Unexpected EOF in length");
            len = (len << 8) + next;
        }
        return len;
    }
}
